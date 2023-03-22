package com.work.service.impl;

import com.work.dao.UserDao;
import com.work.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //引入set方法，进行有参构造的注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl(){}

    @Override
    public void save() {
        userDao.save();
    }
}
