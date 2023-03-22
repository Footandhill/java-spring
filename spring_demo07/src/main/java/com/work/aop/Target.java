package com.work.aop;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("方法实现...");
        //制造异常
        //int i = 1/0;
    }
}
