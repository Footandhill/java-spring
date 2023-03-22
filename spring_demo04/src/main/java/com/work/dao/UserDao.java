package com.work.dao;

import com.work.servlet.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    Long save(final User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delRoleUserRel(Long userId);

    void del(Long userId);

    User findUsernameAndPwd(String username, String password);
}
