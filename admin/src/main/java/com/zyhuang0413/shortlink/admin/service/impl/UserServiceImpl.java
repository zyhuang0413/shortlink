package com.zyhuang0413.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyhuang0413.shortlink.admin.common.constant.RedisCacheConstant;
import com.zyhuang0413.shortlink.admin.common.convention.exception.ClientException;
import com.zyhuang0413.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.zyhuang0413.shortlink.admin.dao.entity.UserDO;
import com.zyhuang0413.shortlink.admin.dao.mapper.UserMapper;
import com.zyhuang0413.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.zyhuang0413.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.zyhuang0413.shortlink.admin.dto.resp.UserRespDTO;
import com.zyhuang0413.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author zyhuang
 * Date: 2023/12/26
 * Time: 21:37
 * Description: 用户接口层实现层
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    private final RedissonClient redissonClient;

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException(UserErrorCodeEnum.USER_IS_NOT_EXIST);
        }
        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }

    @Override
    public Boolean availableUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        if (Boolean.TRUE.equals(availableUsername(requestParam.getUsername()))) {
            throw new ClientException(UserErrorCodeEnum.USER_NAME_IS_EXIST);
        }
        // 引入分布式锁解决用户短时间内恶意请求触发大量请求去注册一个相同但未注册过的用户名
        RLock lock = redissonClient.getLock(RedisCacheConstant.LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        try {
            if (lock.tryLock()) {
                // 插入数据库
                int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                if (inserted < 1) {
                    throw new ClientException(UserErrorCodeEnum.USER_SAVE_FAIL);
                }
                // 写入布隆过滤器
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                return;
            }
            throw new ClientException(UserErrorCodeEnum.USER_NAME_IS_EXIST);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {
        // TODO 验证当前用户名是否为登录用户
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername());
        baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class), updateWrapper);
    }
}
