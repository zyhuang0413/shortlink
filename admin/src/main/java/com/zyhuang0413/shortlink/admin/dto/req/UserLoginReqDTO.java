package com.zyhuang0413.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 2:33
 * Description: 用户登录请求参数实体
 */
@Data
public class UserLoginReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
