package com.springboot.myapp.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class CommonUtils {

    public static void print(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        printLine();
        print("header:");
        StringJoiner sj = new StringJoiner(",");
        if(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            sj.add(print(name,value));
        }
        print(sj.toString());

        printLine();
        print("method:");
        print(request.getMethod());

        printLine();
        print("queryString:");
        print(request.getQueryString());

        printLine();
        print("ip:");
        print(request.getRemoteAddr());

        printLine();
        print("parameter:");
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key,values)->{
            Stream.of(values).forEach(value->{
                print(key,value);
            });
        });
    }

    private static String print(String name,String value){
        return name+":"+value;
    }

    private static void print(String value){
        System.out.print(value);
    }

    private static void printLine(){
        System.out.println();
        System.out.println("========="+getTimestamp()+"=========");
    }

    private static String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
