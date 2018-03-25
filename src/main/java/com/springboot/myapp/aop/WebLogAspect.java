package com.springboot.myapp.aop;

import com.springboot.myapp.utils.LogUtils;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/*
 * AOP日志
 */
@Aspect
@Component
public class WebLogAspect {

    //web日志
    @Pointcut("execution(public * com.springboot.myapp.web..*.*(..))")
    public void webLog(){}

    public void printLog(String str){
        LogUtils.infoPrint(str);
    }

    @Before("webLog()")
    public void doBefore() throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        printLog("############Request-begin###############");
        printLog("URL:"+request.getRequestURI().toString());
        printLog("HTTP_METHOD:"+request.getMethod());
        printLog("IP:"+request.getRemoteAddr());
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String parameter = request.getParameter(name);
            sb.append("name:{"+name+"},value:{"+parameter+"}").append("\n");
        }
        printLog(sb.toString());
        printLog("############Request-end#################");
    }

    @AfterReturning(pointcut = "webLog()",returning = "ret")
    public void doAfterReturning(Object ret){
        printLog("Response:"+ret.toString());
    }

    //service日志

    //dao日志
}
