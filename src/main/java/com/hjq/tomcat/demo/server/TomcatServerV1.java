package com.hjq.tomcat.demo.server;

import com.hjq.tomcat.v1.common.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端和服务器的通信，说到底就是两个数据的传输，客户端发送inputStream给服务器，服务器回复outputStream给客户端
 * 现在以代码模拟这个过程
 **/

public class TomcatServerV1 {
    /**
     * 启动之后，我们在浏览器输入http://localhost:8090/hello,控制台信息显示收到了客户的请求,正是http请求协议的内容
     * 但是我们返回OK，客户端却没有显示，原因就在于客户端只能识别符合HTTP响应协议的数据,我们必须把outputstream的数据让客户端能看懂，其实也很简单，只需要把返回的数据加上HTTP响应协议的报文头部就行
     * 我们新建一个response类，封装响应信息
     */

    public static void main(String[] args) throws IOException {
        // 开启ServerSocket服务，设置端口号为8090
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("=======服务启动成功=======");
        // 服务没有关闭时
        while(!serverSocket.isClosed()) {
            // 使用socket进行通信,等待客户端连接（阻塞状态）
            Socket socket = serverSocket.accept();
            // 接收客户端发来的inputStream
            InputStream inputStream = socket.getInputStream();
            System.out.println("~·收到客户端请求·~");
            System.out.println("正在执行客户请求："+Thread.currentThread());
            // 服务器读取inputStream的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String msg = null;
            // 一行行读取内容
            while((msg= reader.readLine())!=null) {
                if (msg.length()==0) {
                    break;
                }
                System.out.println(msg);
            }
            // 响应客户端么，返回outputStream,主体是OK
            String res = Response.responseBody + "OK";
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(res.getBytes());
            outputStream.flush();
            outputStream.close();
            socket.close();
        }

    }

}





















