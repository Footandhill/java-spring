package com.work.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before(){
        System.out.println("前置增强...");
    }

    public void afterRunning(){
        System.out.println("后置增强...");
    }

    //Proceeding JoinPoint 正在执行的连接点==切点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowable(){
        System.out.println("异常抛出增强...");
    }

    public void after(){
        System.out.println("最终通知...");
    }

}
