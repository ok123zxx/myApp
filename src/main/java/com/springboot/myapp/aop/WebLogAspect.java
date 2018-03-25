package com.springboot.myapp.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(public * com.springboot.myapp.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(Joinpoint joinpoint) throws Throwable{
        System.out.println("进入了党阀");
    }

    @AfterReturning(pointcut = "webLog()",returning = "ret")
    public void doAfterReturning(Object ret){
        System.out.println("准备返回");
    }


}
