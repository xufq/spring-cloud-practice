package com.xufq.loginserver.exception;

/**
 * @ClassName BusinessException
 * @Description Business Exception. If to throw this exception, the http status of response is 400.
 * @Author fangqiang.xu
 * @Date 2/7/2020 09:32 PM
 * @Version 1.0
 */
public class BusinessException extends BaseException {
    public BusinessException() {
    }

    public BusinessException(String errCode) {
        super(errCode);
    }

    public BusinessException(String errCode, String message) {
        super(errCode, message);
    }
}
