package com.zyhuang0413.shortlink.admin.common.convention.exception;

import com.zyhuang0413.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.zyhuang0413.shortlink.admin.common.convention.errorcode.IErrorCode;

import java.util.Optional;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 0:17
 * Description: 服务端异常
 */
public class ServiceException extends AbstractException {

    public ServiceException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(Optional.ofNullable(message).orElse(errorCode.message()), throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
