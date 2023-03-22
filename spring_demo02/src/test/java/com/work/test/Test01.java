package com.work.test;

import com.work.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContest.xml");
        UserService userService = (UserService) app.getBean("UserService");
        userService.save();
    }

}
