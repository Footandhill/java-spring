package com.work.tempTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JDBCTemclateTest1 {

    @Test
    //测试spring产生JDBCTemplate对象
    public void test02() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContest.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        int row = jdbcTemplate.update("insert into spring_text values (?,?)", "张三", 5555);
        System.out.println(row);
    }

    @Test
    //测试JDBCTemplate步骤
    public void test01() throws Exception {
        //创建数据库数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("222222");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据库数据源对象 知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int row = jdbcTemplate.update("insert into spring_text values (?,?)", "tom", 5431);
        System.out.println(row);
    }

}
