package com.threestone.common.base;

import com.sun.prism.impl.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Friday on 2019/5/5.
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;

    protected HttpServletRequest getRequest(){
        return request;
    }
}
