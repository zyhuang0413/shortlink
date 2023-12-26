package com.zyhuang0413.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyhuang0413.shortlink.admin.dao.entity.UserDO;
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
}
