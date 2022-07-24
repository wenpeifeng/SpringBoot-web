package com.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *  1.继承HandlerInterceptor
 *  2.重写preHandle方法
 *  3.在MyMvcConfig中配置bean，过滤请求url
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 重写preHandle方法 true：放行   false：不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // loginUser = null 说明没有登录，跳转至登录页
        Object loginUser =  request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            request.setAttribute("msg","没有权限；请先登录！");
            // 跳转至登录页
            request.getRequestDispatcher("/login.do").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
