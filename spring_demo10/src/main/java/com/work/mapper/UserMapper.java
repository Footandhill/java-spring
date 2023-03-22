package com.work.mapper;

import com.work.servlet.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public void add(User user);

    @Update("update user set username=#{username},password=#{password},birthday=#{birthday} where id=#{id}")
    public void update(User user);

    @Delete("delete from user where id=#{id}")
    public void delete(int id);


    public List<User> findByOne(User user);

    public List<User> findByIds(List<Integer> ids);

}
