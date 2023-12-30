package com.zyhuang0413.shortlink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyhuang0413.shortlink.project.dao.entity.ShortLinkDO;
import com.zyhuang0413.shortlink.project.dao.mapper.ShortLinkMapper;
import com.zyhuang0413.shortlink.project.service.ShortLinkService;
import org.springframework.stereotype.Service;

/**
 * @author zyhuang
 * Date: 2023/12/31
 * Time: 0:13
 * Description: 短链接接口层实现类
 */
@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {
}
