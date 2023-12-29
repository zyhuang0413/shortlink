package com.zyhuang0413.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * @author zyhuang
 * Date: 2023/12/29
 * Time: 21:13
 * Description: 短链接分组查询响应实体
 */
@Data
public class ShortLinkGroupQueryRespDTO {

     /**
      * 分组标识
      */
     private String gid;

     /**
      * 分组名称
      */
     private String name;

     /**
      * 创建分组用户名
      */
     private String username;

     /**
      * 分组排序
      */
     private Integer sortOrder;

}
