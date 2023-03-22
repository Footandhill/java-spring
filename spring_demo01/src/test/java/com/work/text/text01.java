package com.work.text;

import com.work.dao.UserDao;
import com.work.dao.impl.UserDaoImpl;
import com.work.demo.User;
import com.work.service.UserService;
import com.work.substitute.reappdemo01;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

public class text01 {

    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao1 = (UserDao) app.getBean("UserDao");
        userDao1.save();
        // ((ClassPathXmlApplicationContext)app).close();

    }

    @Test
    public void test2(){
        ApplicationContext app = new AnnotationConfigApplicationContext(reappdemo01.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }

}
