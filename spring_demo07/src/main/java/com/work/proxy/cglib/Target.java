package com.work.proxy.cglib;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("方法实现...");
    }
}
