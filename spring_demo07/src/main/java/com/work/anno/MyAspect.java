package com.work.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("pointcut()")
    public void before(){
        System.out.println("前置增强...");
    }

    @AfterReturning("pointcut()")
    public void afterRunning(){
        System.out.println("后置增强...");
    }

    //Proceeding JoinPoint 正在执行的连接点==切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowable(){
        System.out.println("异常抛出增强...");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终通知...");
    }

    @Pointcut("execution(* com.work.anno.*.*(..))")
    public void pointcut(){}

}
