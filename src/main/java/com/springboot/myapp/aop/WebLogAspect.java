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
        if(attributes == null){
            return ;
        }
        HttpServletRequest request = attributes.getRequest();
        if(request == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        printLog("############Request-begin###############");
        printLog("URL:"+request.getRequestURI().toString());
        printLog("HTTP_METHOD:"+request.getMethod());
        printLog("IP:"+request.getRemoteAddr());
        //heaeder信息
        Enumeration<String> headerNames = request.getHeaderNames();
        if(headerNames.hasMoreElements()){
            sb.append("HEADER:\n");
            while(headerNames.hasMoreElements()){
                String key = headerNames.nextElement();
                String header = request.getHeader(key);
                sb.append("key:{").append(key).append("},value{").append(header).append("}").append("\n");
            }
            printLog(sb.toString());
        }

        //参数信息
        Enumeration<String> parameterNames = request.getParameterNames();
        if(parameterNames.hasMoreElements()){
            sb.setLength(0);
            sb.append("PARAMTER:\n");
            while (parameterNames.hasMoreElements()){
                String name = parameterNames.nextElement();
                String parameter = request.getParameter(name);
                sb.append("name:{"+name+"},value:{"+parameter+"}").append("\n");
            }
            printLog(sb.toString());
        }
        printLog("############Request-end#################");
    }

    @AfterReturning(pointcut = "webLog()",returning = "ret")
    public void doAfterReturning(Object ret){
        printLog("Response:"+ret.toString());
    }

    //service日志

    //dao日志
}
