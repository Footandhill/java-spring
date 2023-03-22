package com.work.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.damain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("quick17")
    @ResponseBody
    public void save17(String username, MultipartFile file) throws IOException {
        System.out.println(username);
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File("D:\\Download files\\" + originalFilename));
    }

    @RequestMapping("quick16")
    @ResponseBody
    public void save16(@RequestHeader(value = "User-Agent",required = false) String user_agent ,@CookieValue(value = "JSESSIONID",required = false) String cookie){
        System.out.println(user_agent);
        System.out.println(cookie);
    }

    @RequestMapping("quick15")
    @ResponseBody
    public void save15(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(session);
        System.out.println(request);
        System.out.println(response);
    }

    @RequestMapping("quick14")
    @ResponseBody
    public void save14(Date date){
        System.out.println(date);
    }

    @RequestMapping("quick13")
    @ResponseBody
    public void save13(@RequestParam(value = "name",required = false) String username){
        System.out.println(username);
    }

    @RequestMapping("quick12")
    @ResponseBody
    public void save12(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping("quick11")
    @ResponseBody
    public void save11(String[] str){
        System.out.println(Arrays.asList(str));
    }

    @RequestMapping("quick10")
    @ResponseBody
    public void save10(User user){
        System.out.println(user);
    }

    @RequestMapping("quick9")
    @ResponseBody
    public void save9(String username , int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("quick8")
    @ResponseBody   //告知springMVC框架，不进行视图跳转，直接进行数据响应
    //希望springMVC自动将User转换成json格式的字符串
    public User save8() throws IOException {
        User user = new User();
        user.setName("张三");
        user.setAge(23);

        return user;
    }

    @RequestMapping("quick7")
    @ResponseBody   //告知springMVC框架，不进行视图跳转，直接进行数据响应
    public String save7() throws IOException {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        //使用json的转换工具将对象转换成json格式字符串再发货
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping("quick6")
    @ResponseBody   //告知springMVC框架，不进行视图跳转，直接进行数据响应
    public String save6(){
        return "hello";
    }

    @RequestMapping("quick5")
    public void save5(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello 你好");
    }

    @RequestMapping("quick4")
    public String save4(HttpServletRequest request){
        request.setAttribute("username","456qwe");
        return "index";
    }

    @RequestMapping("quick3")
    public String save3(Model model){
        model.addAttribute("username","325qwe");
        return "index";
    }

    @RequestMapping("quick2")
    public ModelAndView save2(ModelAndView mav){
        //设置模型数据
        mav.addObject("username","224qwe");
        //设置视图名称
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("quick1")
    public ModelAndView save1(){
        /*
        Model：作用封装数据
        View: 作用展示数据
         */
        ModelAndView mav = new ModelAndView();
        //设置模型数据
        mav.addObject("username","123qwe");
        //设置视图名称
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/quick")
    public String save(){
        System.out.println("save正在运行中....");
        return "index.jsp";
    }

}
