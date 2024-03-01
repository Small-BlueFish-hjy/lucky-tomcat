package com.hjq.tomcat.v1.http;

import java.io.*;

/**
 * @program: hjq_tomcat
 * @description: 封装请求数据
 * @author: hjq
 * @create: 2024-03-01 20:48
 **/

public class Request {
    //获取URI，如 /user
    private String uri;
    //获取请求方法，这里只写get和post
    private String method;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Request(InputStream inputStream) {
        try {
            //获取inputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            //获取HTTP请求响应的第一行，如：GET /user HTTP/1.1【按空格隔开】
            String[] data = reader.readLine().split(" ");
            //取uri和method
            this.uri=data[1];
            this.method=data[0];
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
