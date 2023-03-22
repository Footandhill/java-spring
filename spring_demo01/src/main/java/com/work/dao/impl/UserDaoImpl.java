package com.work.dao.impl;

import com.work.dao.UserDao;
import com.work.demo.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {


//    //集合数据
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties props;
//
    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    //普通数据
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        //System.out.println(username + "==" + age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(props);
        System.out.println("sava running....");
    }

//    public void init(){
//        System.out.println("初始化...");
//    }
//    public void destory(){
//        System.out.println("销毁方法...");
//    }

}
