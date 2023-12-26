package com.zyhuang0413.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * @author zyhuang
 * Date: 2023/12/26
 * Time: 21:50
 * Description: 用户返回参数响应实体
 */
@Data
public class UserRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

}
