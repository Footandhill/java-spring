package com.work;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.entity.Book;
import com.work.entity.query.BookQuery;
import com.work.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootDemo01ApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void textdemo01() {
//        多条删除
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(4L);
        bookMapper.deleteBatchIds(list);

    }

    @Test
    void textdemo02() {
//        模拟前端传输的数据
        BookQuery bq = new BookQuery();
        bq.setPrice(16.8);
        bq.setPrice2(89.6);
//        条件查询
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.lt(Book::getPrice,bq.getPrice());
        //.lt(bq.getPrice2()!=null, Book::getPrice,bq.getPrice2());
    }

    @Test
    void textdemo03() {
//        查询投影
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        QueryWrapper<Book> qw = new QueryWrapper<>();
        lqw.select(Book::getId,Book::getName);//查询的列
        //qw.select("id","name");
        List<Book> books = bookMapper.selectList(lqw);

        qw.select("count(*) as count,price")
                .groupBy("price");//按价格分组查询
        List<Map<String, Object>> maps = bookMapper.selectMaps(qw);
    }

    @Test
    void textdemo04() {
        //逻辑删除
        bookMapper.deleteById(3);
    }

    @Test
    void textdemo05() {
//        乐观锁
        Book book1 = bookMapper.selectById(4);      //version=4
        Book book2 = bookMapper.selectById(4);
//        模拟两用户同时进行修改的场景
        book1.setName("1");
        bookMapper.updateById(book1);
        book2.setName("2");
        bookMapper.updateById(book2);//不进行修改
    }

}
