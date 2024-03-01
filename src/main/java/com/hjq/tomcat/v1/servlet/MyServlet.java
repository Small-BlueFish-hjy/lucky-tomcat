package com.hjq.tomcat.v1.servlet;

import com.hjq.tomcat.v1.common.Response;
import com.hjq.tomcat.v1.http.Request;

/**
 * tomcat使用servlet进行请求处理，我们平常使用servlet时，会继承HttpServlet这个抽象类，然后重写里面的doGet，doPost等方法，
 * 最源头还会继承一个Servlet接口，该接口主要提供init，service等方法
 *
 * 我们也用同样的方式来实现，首先建一个MyServlet接口，
 * 然后创建一个抽象类MyHttpServlet继承接口，最后建一个UserServlet实现具体的doGet，doPost等方法
 *
 * @author hjq
 */
public interface MyServlet {
    /**
     * 初始化方法
     * @throws Exception
     */
    void init() throws Exception;

    /**
     * 服务
     * @param request
     * @param response
     * @throws Exception
     */
    void service(Request request, Response response) throws Exception;

    /**
     * 销毁
     */
    void destory();
}
