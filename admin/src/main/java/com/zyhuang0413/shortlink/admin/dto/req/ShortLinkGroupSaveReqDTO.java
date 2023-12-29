package com.zyhuang0413.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 2:33
 * Description: 短链接新增分组请求实体
 */
@Data
public class ShortLinkGroupSaveReqDTO {

    /**
     * 分组名称
     */
    private String name;

}
