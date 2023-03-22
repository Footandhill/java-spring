package com.work.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override       //在目标方法执行之前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle....");
        String parame = request.getParameter("param");
        if (parame.equals("yes")){
            return true;
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;        //返回true表示放行  返回false表示不放行
        }
    }

    @Override       //在目标方法执行之后，视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name","wo...");
        System.out.println("postHandle....");
    }

    @Override       //在所有流程执行完毕之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion....");
    }
}
