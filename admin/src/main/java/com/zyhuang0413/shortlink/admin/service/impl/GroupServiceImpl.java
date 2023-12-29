package com.zyhuang0413.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyhuang0413.shortlink.admin.dao.entity.GroupDO;
import com.zyhuang0413.shortlink.admin.dao.mapper.GroupMapper;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.zyhuang0413.shortlink.admin.service.GroupService;
import com.zyhuang0413.shortlink.admin.tookit.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zyhuang
 * Date: 2023/12/29
 * Time: 15:26
 * Description: 分组接口层实现层
 */
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public void saveGroup(ShortLinkGroupSaveReqDTO requestParam) {
        String gid;
        do {
            gid = RandomGenerator.generateRandom();
        } while (!availableGroupId(gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(requestParam.getName())
                .sortOrder(0)
                .build();
        baseMapper.insert(groupDO);
    }

    private boolean availableGroupId(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                // TODO 设置用户名
                .eq(GroupDO::getUsername, null);
        return baseMapper.selectOne(queryWrapper) == null;
    }

}
