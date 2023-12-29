package com.zyhuang0413.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyhuang0413.shortlink.admin.dao.entity.GroupDO;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.zyhuang0413.shortlink.admin.dto.resp.ShortLinkGroupQueryRespDTO;

import java.util.List;

/**
 * @author zyhuang
 * Date: 2023/12/29
 * Time: 15:24
 * Description: 分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短链接分组
     *
     * @param requestParam 短链接新增分组请求参数
     */
    void saveGroup(ShortLinkGroupSaveReqDTO requestParam);

    /**
     * 查询短链接分组
     *
     * @return 分组聚合
     */
    List<ShortLinkGroupQueryRespDTO> listGroup();
}
