package com.zyhuang0413.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyhuang0413.shortlink.admin.common.convention.exception.ClientException;
import com.zyhuang0413.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.zyhuang0413.shortlink.admin.dao.entity.UserDO;
import com.zyhuang0413.shortlink.admin.dao.mapper.UserMapper;
import com.zyhuang0413.shortlink.admin.dto.resp.UserRespDTO;
import com.zyhuang0413.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author zyhuang
 * Date: 2023/12/26
 * Time: 21:37
 * Description: 用户接口层实现层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
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
}
