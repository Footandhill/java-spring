package com.work.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.work.mapper.UserMapper;
import com.work.servlet.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTset {

    private UserMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);

        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test04() throws IOException {

        //设置分页相关参数
        PageHelper.startPage(3,3);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
//        PageInfo<User> pageInfo = new PageInfo<>(userList);
//        System.out.println("当前页："+pageInfo.getPageNum());
//        System.out.println("每页显示条数："+pageInfo.getPageSize());
//        System.out.println("总条数："+pageInfo.getTotal());
//        System.out.println("总页数："+pageInfo.getPages());
//        System.out.println("上一页："+pageInfo.getPrePage());
//        System.out.println("下一页："+pageInfo.getNextPage());
//        System.out.println("是否是第一个："+pageInfo.isIsFirstPage());
//        System.out.println("是否是最后一个："+pageInfo.isIsLastPage());

        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {

        User condition = new User();
        condition.setId(8);
        List<User> one = mapper.findByOne(condition);
        System.out.println(one);

        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {

        User useradd = new User();
        useradd.setId(8);
        useradd.setUsername("hello");
        useradd.setPassword("world");
        useradd.setBirthday(new Date());
        mapper.add(useradd);

        sqlSession.close();
    }

    @Test
    public void test01() throws IOException {

        List<User> userList = mapper.findAll();
        System.out.println(userList);

        User useradd = new User();
        useradd.setId(8);
        useradd.setUsername("hello");
        useradd.setPassword("world");
        useradd.setBirthday(new Date());
        mapper.add(useradd);

        User userupdate = new User();
        userupdate.setId(7);
        userupdate.setUsername("王麻子");
        userupdate.setPassword("1234");
        mapper.update(userupdate);

        User condition = new User();
        condition.setId(2);
        List<User> one = mapper.findByOne(condition);
        System.out.println(one);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> users = mapper.findByIds(ids);
        System.out.println(users);

        sqlSession.close();
    }

}
