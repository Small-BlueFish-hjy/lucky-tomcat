package com.hjq.tomcat.v1.servlet.impl;

import com.hjq.tomcat.v1.common.Response;
import com.hjq.tomcat.v1.http.Request;
import com.hjq.tomcat.v1.servlet.MyServlet;

/**
 * @program: hjq_tomcat
 * @description:
 * @author: hjq
 * @create: 2024-03-01 21:01
 **/

public abstract class MyHttpServlet implements MyServlet {

    //如果有请求过来，就会调用这个方法，然后再根据请求类型来调用不同的doXXX()方法
    @Override
    public void service(Request request, Response response) throws Exception {
        if ("get".equalsIgnoreCase(request.getMethod())) {
            this.doGet(request, response);
        } else if ("post".equalsIgnoreCase(request.getMethod())) {
            this.doPost(request, response);
        }
    }

    public abstract void doGet(Request request, Response response);
    public abstract void doPost(Request request, Response response);

    public static void main(String[] args) {
        String method = "get";
        boolean result = method.equalsIgnoreCase("Get");
        System.out.println(result);
    }


}
