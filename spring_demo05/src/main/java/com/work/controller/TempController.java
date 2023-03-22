package com.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TempController {

    @RequestMapping("/target")
    public ModelAndView target(){
        System.out.println("目标资源执行...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","work");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
