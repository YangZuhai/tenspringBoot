package com.hxzyyn.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lulei
 * @date 2021年12月16日 20:14:22
 */

public class InterceptorOne implements HandlerInterceptor {
    //请求最先经过的方法 返回为true放行请求  返回为false中断请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("1");

        ServletContext application = request.getSession().getServletContext();
        if (application.getAttribute("account") == null) {
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }

    //控制器方法执行完成之后进入这个方法执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("3");
    }

    //最后执行的方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("4");
    }
}
