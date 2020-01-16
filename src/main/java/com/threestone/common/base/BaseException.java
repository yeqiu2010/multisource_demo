package com.threestone.common.base;

/**
 * 基础异常类
 * Created by Friday on 2018/11/12.
 */
public class BaseException extends RuntimeException{

    public final static String ERRCODE_DEFAULT_INNER = "500";

    /** @Fields errCode: 内部定义错误码 */
    private String errCode;

    /** @Fields errMsg: 错误信息 */
    private String errMsg;

    public BaseException(String errCode, String errMsg){
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
