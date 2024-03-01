package com.hjq.tomcat.v1.servlet.impl;

import com.hjq.tomcat.v1.common.Response;
import com.hjq.tomcat.v1.http.Request;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: hjq_tomcat
 * @description: 接收客户端请求，并根据请求方法类型调用对应方法，响应数据给客户端
 * @author: hjq
 * @create: 2024-03-01 22:15
 **/

public class UserServlet extends MyHttpServlet {
    @Override
    public void init() throws Exception {
    }

    @Override
    public void destory() {
    }

    @Override
    public void doGet(Request request, Response response) {
        this.doPost(request, response);
    }

    @Override
    public void doPost(Request request, Response response) {
        try {
            //省略业务调用的代码，tomcat会根据request对象里面的inputStream拿到对应的参数进行业务调用
            //模拟业务层调用后的返回
            OutputStream outputStream = response.outputStream;
            String result = Response.responseBody + "user handle successful";
            outputStream.write(result.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
