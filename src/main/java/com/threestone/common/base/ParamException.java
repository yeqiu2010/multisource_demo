package com.threestone.common.base;

/**
 * 参数异常
 * Created by Friday on 2018/11/12.
 */
public class ParamException extends BaseException{

    /** @Fields paramName: 参数名称 */
    private String paramName;

    /** @Fields paramValue: 参数值 */
    private String paramValue;

    public ParamException(String errCode, String errMsg){
        super(errCode, errMsg);
    }

    public ParamException(String errCode, String errMsg, String paramName, String paramValue){
        super(errCode, errMsg);
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
