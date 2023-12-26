package com.zyhuang0413.shortlink.admin.common.convention.exception;

import com.zyhuang0413.shortlink.admin.common.convention.errorcode.IErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 0:07
 * Description: 抽象异常类，抽象项目中三种异常体系：客户端异常、服务端异常以及远程服务调用异常
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 */
@Getter
public abstract class AbstractException extends RuntimeException {

     public final String errorCode;

     public final String errorMessage;

     public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
          super(message, throwable);
          this.errorCode = errorCode.code();
          this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
     }
}