package com.zyhuang0413.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyhuang0413.shortlink.admin.dao.entity.GroupDO;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
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

    /**
     * 修改短链接分组名称
     *
     * @param requestParam 短链接修改分组请求参数
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除短链接分组
     *
     * @param gid 短链接分组标识
     */
    void deleteGroup(String gid);

    /**
     * 短链接分组排序
     *
     * @param requestParam 短链接分组排序请求参数
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
