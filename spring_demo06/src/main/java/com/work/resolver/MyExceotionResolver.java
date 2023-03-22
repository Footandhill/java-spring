package com.work.resolver;

import com.work.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceotionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MyException){
            modelAndView.addObject("abc","自定义异常");
        } else if (e instanceof ClassCastException) {
            modelAndView.addObject("abc","类型转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
