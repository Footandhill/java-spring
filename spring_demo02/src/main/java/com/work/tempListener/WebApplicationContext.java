package com.work.tempListener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContext {

    public static ApplicationContext getWAC(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }

}
