package com.work.proxy.jdk;


import com.work.proxy.cglib.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        final Target target = new Target();
        final Advice advice = new Advice();

        //返回值 动态生成代理对象 基于cglib
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.after();
                return invoke;
            }
        });
        //4.创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();

    }


}
