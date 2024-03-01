package com.hjq.tomcat.demo.common;

import java.io.OutputStream;

/**
 * 封装响应信息，符合HTTP响应协议的数据
 * @author 86152
 */

public class Response {

    public OutputStream outputStream;

    public static final String responseBody = "HTTP/1.1 200+\r\n"+"Content-Type: text/html+\r\n"+"\r\n";

    public Response(OutputStream outputStream) {
        this.outputStream=outputStream;
    }

}












