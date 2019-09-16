package com.liuxing.common.jwt;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token验证拦截器
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtUtils jwt;

    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String servletPath = request.getServletPath();
        System.out.println("ServletPath: " + servletPath);
        // 不需要验证,直接放行
        boolean isNotCheck = isNotCheck(servletPath);
        if (isNotCheck) {
            return true;
        }
        // 需要验证
        String token = getToken(request);

        if (StringUtils.isBlank(token)) {
            throw new Exception(JwtUtils.header + "失效,请重新登录");
        }
        // 获取签名信息
        Claims claims = jwt.getClaimByToken(token);
        System.out.println("TOKEN: " + claims);
        // 判断签名是否存在或过期
        boolean b = claims==null || claims.isEmpty() || jwt.isTokenExpired(claims.getExpiration());
        if (b) {
            throw new Exception(JwtUtils.header + "失效,请重新登录");
        }
        // 将签名中获取的用户信息放入request中;
        request.setAttribute(USER_KEY, claims.getSubject());
        return true;
    }

    /**
     * 根据URL判断当前请求是否不需要校验, true:需要校验
     */
    public boolean isNotCheck(String servletPath) {
        // 若 请求接口 以 / 结尾, 则去掉 /
        servletPath = servletPath.endsWith("/")
                ? servletPath.substring(0,servletPath.lastIndexOf("/"))
                : servletPath;
        System.out.println("servletPath = " + servletPath);
        for (String path : NOT_CHECK_URL) {
            System.out.println("path = " + path);
            // path 以 /** 结尾, servletPath 以 path 前缀开头
            if (path.endsWith("/**")) {
                String pathStart = path.substring(0, path.lastIndexOf("/")+1);
                System.out.println("pathStart = " + pathStart);
                if (servletPath.startsWith(pathStart)) {
                    return true;
                }
                String pathStart2 = path.substring(0, path.lastIndexOf("/"));
                System.out.println("pathStart2 = " + pathStart2);
                if (servletPath.equals(pathStart2)) {
                    return true;
                }
            }
            // servletPath == path
            if (servletPath.equals(path)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取请求Token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(JwtUtils.header);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(JwtUtils.header);
        }
        return token;
    }

    /**
     * 不用拦截的页面路径(也可存入数据库中), 不要以 / 结尾
     */
    private static final String[] NOT_CHECK_URL = {"/test/**", "/loginPage/**"};
}
