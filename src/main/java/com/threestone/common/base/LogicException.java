package com.threestone.common.base;

/**
 * 逻辑异常，指应用程序判断并手工抛出的
 * Created by Friday on 2019/5/6.
 */
public class LogicException extends BaseException {
    public LogicException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
