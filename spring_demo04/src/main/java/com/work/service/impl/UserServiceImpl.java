package com.work.service.impl;

import com.work.dao.RoleDao;
import com.work.dao.UserDao;
import com.work.service.UserService;
import com.work.servlet.Role;
import com.work.servlet.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个User的roles数据
        for (User user : userList) {
            //获得user中的id
            Long id = user.getId();
//            将id作为参数，查询当前userId对应的Role集合参数
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //向sys_user表中储存数据
        Long userId = userDao.save(user);
        //向sys_user_role关系表中储存多条数据
        userDao.saveUserRoleRel(userId,roleIds);

    }

    @Override
    public void del(Long userId) {
        //删除sys_role_user关系表数据
        userDao.delRoleUserRel(userId);
        //删除sys_user数据表数据
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.findUsernameAndPwd(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }



    }
}
