package com.work.tempListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaldListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

//        ServletContext servletContext = servletContextEvent.getServletContext();
//        //读取全局参数
//        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
//
//        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
//        //将spring应用上下文对象储存到servletContext域中
//
//        servletContext.setAttribute("app",app);
//        System.out.println("spring....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
