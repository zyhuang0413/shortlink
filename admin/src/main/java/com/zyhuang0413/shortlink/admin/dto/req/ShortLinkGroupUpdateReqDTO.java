package com.zyhuang0413.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 2:33
 * Description: 短链接修改分组请求实体
 */
@Data
public class ShortLinkGroupUpdateReqDTO {

    /**
     * 分组ID
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

}
