package com.work.controller;

import com.work.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContest.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("tom","lucy",500);
    }

}
