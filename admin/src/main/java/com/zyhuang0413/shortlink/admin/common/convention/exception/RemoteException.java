package com.zyhuang0413.shortlink.admin.common.convention.exception;

import com.zyhuang0413.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.zyhuang0413.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 0:19
 * Description: 远程调用异常
 */
public class RemoteException extends AbstractException {

    public RemoteException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
