package com.threestone.common.base;

import com.threestone.model.JsonResp;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统异常捕获处理
 * Created by Friday on 2019/5/6.
 */
@ControllerAdvice
public class AdminExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(AdminExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public @ResponseBody
    JsonResp exceptionHandler(Exception exception) {
        // TODO: 后续加上标记控制，是否在控制台打印
        exception.printStackTrace();

        JsonResp resp = new JsonResp();
        resp.setState(JsonResp.STATE_ERR);

        Class<? extends Exception> cls = exception.getClass();

        if (cls.isAssignableFrom(LogicException.class)) {
            // 逻辑异常
            resp.setCode(((LogicException) exception).getErrCode());
            resp.setMsg(((LogicException) exception).getErrMsg());
        } else if (cls.isAssignableFrom(ParamException.class)) {
            // 参数异常
            resp.setCode(((ParamException) exception).getErrCode());
            resp.setMsg(((ParamException) exception).getErrMsg());
        } else {
            // 其他服务器异常
            resp.setCode(BaseException.ERRCODE_DEFAULT_INNER);
            resp.setMsg(ExceptionUtils.getRootCauseMessage(exception));
//            resp.setExceptionStackTrace(ExceptionUtils.getStackTrace(exception));
        }
        return resp;
    }
}
