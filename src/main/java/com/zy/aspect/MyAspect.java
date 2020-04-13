package com.zy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MyAspect {
//    @Before("my()")
//    public void before(JoinPoint jp){
//        String name1 = jp.getSignature().getName();
//        Class<?> aClass = jp.getTarget().getClass();
//        Date date = new Date();
//        System.out.println("这个类["+aClass+"]要执行这个方法["+name1+"]");
//        System.out.println("现在时间"+date+"=============要开始删除了哦!!!!!!");
//    }

//    @Pointcut(value = "execution(* com.zy.service.UserService.delete(int))")
//    public void my(){}

//    @AfterReturning("my()")
//    public void afterReturning(){
//        System.out.println("删除完了哦");
//    }

//    @Around("my()")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//
//        MethodSignature signature = (MethodSignature) pjp.getSignature();
//        Method intef_method = signature.getMethod();
//        System.out.println("method1为："+intef_method);//这是cn.tedu.service.UserService.addUser()
//
//        Class<?> clz = pjp.getTarget().getClass();
//        System.out.println("class为："+clz);//class cn.tedu.service.UserServiceImpl
//
//        Method inst_method = clz.getMethod(intef_method.getName(), intef_method.getParameterTypes());
//        System.out.println("method2为："+inst_method);//这是cn.tedu.service.UserServiceImpl.addUser()
//
//        System.out.println("环绕之前");
//       Object proceed = pjp.proceed();  //不写这个操作，目标方法将不会执行
//        System.out.println("环绕之后");
//        return new Object();
//    }
}
