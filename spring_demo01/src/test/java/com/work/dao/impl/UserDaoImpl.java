package com.work.dao.impl;

import com.work.dao.UserDao;
import com.work.demo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private String user;

    public UserDaoImpl() {
    }

    public UserDaoImpl(String user) {
        this.user = user;
    }


    /**
     * 获取
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }


    @Override
    public void save() {
        System.out.println("sava.....");
    }

}
