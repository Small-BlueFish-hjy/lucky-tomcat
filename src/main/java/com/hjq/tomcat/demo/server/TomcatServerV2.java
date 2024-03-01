package com.hjq.tomcat.demo.server;


import com.hjq.tomcat.demo.common.RequestHandle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: hjq_tomcat
 * @description: BIO模型改进
 * @author: hjq
 * @create: 2024-03-01 12:03
 **/

public class TomcatServerV2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("=======服务器启动======");
        while(!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            // 对于每个连接，都开启一个线程
            RequestHandle requestHandle = new RequestHandle(socket);
            new Thread(requestHandle).start();
        }
    }
}
