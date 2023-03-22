package com.work.tempTest;

import com.work.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContest.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    //查询单个数据
    public void selectcount(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from spring_text", int.class);
        System.out.println(count);
    }

    @Test
    //查询单个数据
    public void selectone(){
        Account tom = jdbcTemplate.queryForObject("select * from spring_text where sname=?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(tom);
    }

    @Test
    //查询所有数据
    public void selectdate(){
        List<Account> query = jdbcTemplate.query("select * from spring_text", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }

    @Test
    //修改数据
    public void update(){
        jdbcTemplate.update("update spring_text set smoney=? where sname=?",2000,"tom");
    }

}
