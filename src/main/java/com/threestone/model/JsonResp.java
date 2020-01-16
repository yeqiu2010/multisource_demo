package com.threestone.model;

import com.threestone.common.base.ParamException;
import org.springframework.util.StringUtils;

/**
 * 标准HTTP请求返回对象，统一用此封装
 * Created by Friday on 2018/11/12.
 */
public class JsonResp<T> {

    public final static String STATE_SUCCESS = "success";

    public final static String STATE_ERR = "error";

    public final static String STATE_WARN = "warn";

    private String state;

    private String code;

    private String msg;

    private T data;

    public JsonResp(){}

    public JsonResp(String state) throws Exception{
        if(StringUtils.isEmpty(state)){
            throw new ParamException("", "不能以空参数创建JsonResp");
        }
        if (!state.equals(JsonResp.STATE_SUCCESS)
                && !state.equals(JsonResp.STATE_ERR)
                && !state.equals(JsonResp.STATE_WARN)){
            throw new ParamException("", "创建JsonResp参数非法");
        }
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
