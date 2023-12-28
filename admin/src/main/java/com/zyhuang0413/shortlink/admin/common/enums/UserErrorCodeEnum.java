package com.zyhuang0413.shortlink.admin.common.enums;

import com.zyhuang0413.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 0:23
 * Description: 用户错误码定义
 */
public enum UserErrorCodeEnum implements IErrorCode {

    // 用户名已存在
    USER_NAME_IS_EXIST("A000101", "用户名已存在"),
    // 用户账户不存在
    USER_IS_NOT_EXIST("A000102", "用户账户不存在"),
    // 用户注册失败
    USER_SAVE_FAIL("A000103", "用户注册失败");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
