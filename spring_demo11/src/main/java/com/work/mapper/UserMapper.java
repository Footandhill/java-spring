package com.work.mapper;

import com.work.servlet.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public List<User> findUserAndRoleAll();

}
