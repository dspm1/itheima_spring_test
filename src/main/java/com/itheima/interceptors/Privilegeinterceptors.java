package com.itheima.interceptors;

import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jiang
 * @version 1.0
 * @description TODO
 * @date 2022-03-18 14:04
 */
public class Privilegeinterceptors implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            //没有登录成功
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }

}
