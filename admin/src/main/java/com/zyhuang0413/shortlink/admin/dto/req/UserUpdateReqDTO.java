package com.zyhuang0413.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 16:31
 * Description: 用户信息修改请求参数实体
 */
@Data
public class UserUpdateReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
