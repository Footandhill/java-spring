package com.work.faction;

import com.work.dao.UserDao;
import com.work.dao.impl.UserDaoImpl;


public class User_DyFactroy {

    public UserDao getUser(){
        return new UserDaoImpl();
    }

}
