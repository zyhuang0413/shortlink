package com.zyhuang0413.shortlink.admin.contoller;

import cn.hutool.core.bean.BeanUtil;
import com.zyhuang0413.shortlink.admin.common.convention.result.Result;
import com.zyhuang0413.shortlink.admin.common.convention.result.Results;
import com.zyhuang0413.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.zyhuang0413.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.zyhuang0413.shortlink.admin.dto.resp.UserActualRespDTO;
import com.zyhuang0413.shortlink.admin.dto.resp.UserRespDTO;
import com.zyhuang0413.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/short-link/admin/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/short-link/admin/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * 查询用户名是否存在
     */
    @GetMapping("/api/short-link/admin/v1/user/avl-username/{username}")
    public Result<Boolean> availableUsername(@PathVariable("username") String username) {
        return Results.success(userService.availableUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("/api/short-link/admin/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/api/short-link/admin/v1/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }
}
