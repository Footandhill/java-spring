package com.work.proxy.cglib;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        final Target target = new Target();
        final Advice advice = new Advice();

        //返回值 动态生成代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象类加载器
                target.getClass().getInterfaces(),  //目标对象相同接口的字节码对象数组
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before();
                        //执行目标方法
                        Object invoke = method.invoke(target, args);
                        //后置增强
                        advice.after();
                        return invoke;
                    }
                }
        );

        proxy.save();

    }


}
