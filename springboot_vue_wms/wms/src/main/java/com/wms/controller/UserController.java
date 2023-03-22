package com.wms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.entity.Menu;
import com.wms.service.MenuService;
import com.wms.untils.MyResult;
import com.wms.untils.SeparatePageParam;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;


    //查询
    @GetMapping("/list")
    public List<User> list(){
        //return userService.list();
        return userService.listAll();
    }


    //登录
    @PostMapping("/login")
    public MyResult login(@RequestBody User user){
        List list = userService.lambdaQuery().eq(User::getNo,user.getNo()).eq(User::getPassword,user.getPassword()).list();

        if (list.size()>0){
            User user1 = (User) list.get(0);
            List menuList = menuService.lambdaQuery().like(Menu::getMenuright, user1.getRoleId()).list();
            HashMap res = new HashMap();
            res.put("user",user1);
            res.put("menu",menuList);
            return MyResult.suc(res);
        }
        return MyResult.fail();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //修改
    @PostMapping("/update")
    public boolean update(@RequestBody User user){
        return userService.updateById(user);
    }
    //新增或修改
    @PostMapping("/savaOrUpdateById")
    public boolean savaOrUpdateById(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删除
    @PostMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    //查询（模糊、匹配）
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(user.getName())){
            lambdaQueryWrapper.like(User::getName,user.getName());
        }
        return userService.list(lambdaQueryWrapper);
    }
    //模糊查询分页
    @PostMapping("/pageC")
    public List<User> pageC(@RequestBody SeparatePageParam pageParam){

        HashMap param = pageParam.getParam();
        String name = (String) param.get("name");
        Page<User> page = new Page<>();
        //设置当前页和每页条数
        page.setCurrent(pageParam.getPageNum());
        page.setSize(pageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName,name);

        IPage result = userService.page(page, lambdaQueryWrapper);

        return result.getRecords();
    }

    //分页
    @PostMapping("/page")
    public List<User> page(@RequestBody SeparatePageParam pageParam){

        Page<User> page = new Page<>();
        //设置当前页和每页条数
        page.setCurrent(pageParam.getPageNum());
        page.setSize(pageParam.getPageSize());

        List<User> user = userService.pageC(page);

        return user;
    }

    @PostMapping("/page1")
    public MyResult page1(@RequestBody SeparatePageParam pageParam){

        Page<User> page = new Page<>();
        //设置当前页和每页条数
        page.setCurrent(pageParam.getPageNum());
        page.setSize(pageParam.getPageSize());

        List<User> user = userService.pageC(page);

        return MyResult.suc(user);
    }

}
