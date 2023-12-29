package com.zyhuang0413.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyhuang0413.shortlink.admin.dao.entity.GroupDO;
import com.zyhuang0413.shortlink.admin.dao.mapper.GroupMapper;
import com.zyhuang0413.shortlink.admin.service.GroupService;
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

}
