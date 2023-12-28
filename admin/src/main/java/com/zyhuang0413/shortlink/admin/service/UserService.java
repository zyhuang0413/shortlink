package com.zyhuang0413.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyhuang0413.shortlink.admin.dao.entity.UserDO;
import com.zyhuang0413.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.zyhuang0413.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.zyhuang0413.shortlink.admin.dto.resp.UserRespDTO;

/**
 * @author zyhuang
 * Date: 2023/12/26
 * Time: 21:36
 * Description: 用户接口层
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户返回实体
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return 用户名存在：true,s用户名不存在：false
     */
    Boolean availableUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 修改用户信息
     *
     * @param requestParam 修改用户信息请求参数
     */
    void update(UserUpdateReqDTO requestParam);
}
