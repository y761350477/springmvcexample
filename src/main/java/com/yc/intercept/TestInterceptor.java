package com.yc.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YC on 2017/6/22.
 */
public class TestInterceptor implements HandlerInterceptor {
    /*请求处理前的操作*/
//    返回值false:请求终止；
//          true：执行请求；
//          Object 参数表示的时被拦截目标的对象
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("执行到了preHandle方法");
        System.out.println(o);
        //拦截器处理乱码问题
        httpServletRequest.setCharacterEncoding("utf-8");
        //模拟用户登录，session为空，跳转到登录页面
        /*if (httpServletRequest.getSession().getAttribute("user") == null) {
//            httpServletRequest.getRequestDispatcher("/jsp/Login.jsp").forward(httpServletRequest,httpServletResponse);//转发
            httpServletResponse.sendRedirect("/jsp/Login.jsp");//重定向
            return false;
        }*/
        return true;
    }
    /*请求处理后的操作*/
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("执行到了postHandle方法");
        //ModelAndView的对象的优先级大于被拦截的目标对象
        /*modelAndView.addObject("test1", "testValue测试拦截器");
        modelAndView.setViewName("Msg");*/
    }
    /*请求结束后的操作*/
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("执行到了afterCompletion方法");
    }
}
