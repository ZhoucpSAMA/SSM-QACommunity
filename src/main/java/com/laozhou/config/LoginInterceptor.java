package com.laozhou.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //return true;会放行，执行下一个拦截器。
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("userSession");
        String requestURI = request.getRequestURI();
        if(userSession!=null){
            return true;
        }
        response.sendRedirect("/");
//        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

}
