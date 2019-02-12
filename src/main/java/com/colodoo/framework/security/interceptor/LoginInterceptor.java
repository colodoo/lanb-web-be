package com.colodoo.framework.security.interceptor;

import com.colodoo.framework.common.SessionObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	log.info("登录拦截 请求路径：{}", request.getRequestURI());
    	HttpSession session = request.getSession();
        //判断是否登录
        SessionObject sessionObject = (SessionObject) session.getAttribute("sessionObject");
        if (sessionObject != null) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/user/loginCheck");
            return false;
        }
    }
}
