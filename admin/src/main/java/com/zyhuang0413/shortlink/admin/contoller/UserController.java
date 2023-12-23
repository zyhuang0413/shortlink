package com.zyhuang0413.shortlink.admin.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyhuang
 * Date: 2023/12/24
 * Time: 0:03
 * Description: 用户管理控制层
 */
@RestController
public class UserController {

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public String getUserByUsername(@PathVariable("username") String username) {
        return "Hi " + username;
    }

}
