package com.zyhuang0413.shortlink.admin.contoller;

import com.zyhuang0413.shortlink.admin.common.convention.result.Result;
import com.zyhuang0413.shortlink.admin.common.convention.result.Results;
import com.zyhuang0413.shortlink.admin.dto.resp.UserRespDTO;
import com.zyhuang0413.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

}
