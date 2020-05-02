package com.wh.aop.cutmethod;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 切面
 * 一般用环绕
 * 前面会有顺序不一致的问题
 */

@Aspect
@Component
public class LogTest  {

    @Pointcut("execution(* com.wh.aop.impl.HelloImpl.*(..))")
    public void pt1(){}

//    @Before("pt1()")
    public void before(){
        System.out.println("前置通知");
    }

//    @AfterReturning("pt1()")
    public void afterReturning(){
        System.out.println("后置通知");
    }

//    @AfterThrowing("pt1()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    @Around("pt1()")
    public Object printArroundLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();

            System.out.println("logger类的 打印方法开始记录日志  前置   ");
            rtValue=pjp.proceed(args );
            System.out.println("logger类的 打印方法开始记录日志  后置   ");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("logger类的 打印方法开始记录日志  异常" +
                    "   ");
            throwable.printStackTrace();
        }finally {
            System.out.println("logger类的 打印方法开始记录日志  最终   "+rtValue);
        }
        return rtValue;
    }
}
