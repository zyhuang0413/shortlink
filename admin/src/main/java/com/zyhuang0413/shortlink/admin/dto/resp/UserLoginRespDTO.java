package com.zyhuang0413.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 2:33
 * Description: 用户登录返回参数响应实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRespDTO {

    /**
     * 用户 token
     */
    private String token;

}
