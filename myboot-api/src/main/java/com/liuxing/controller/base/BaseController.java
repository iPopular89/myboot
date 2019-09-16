package com.liuxing.controller.base;

import com.liuxing.common.jwt.JwtInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public abstract  class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取当前登录用户ID
     * @author geYang
     * @date 2018-05-18 19:46
     */
    protected Long getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return Long.parseLong(request.getAttribute(JwtInterceptor.USER_KEY).toString());
    }
}
