## 理论知识
### tomcat的作用
> tomcat可以说，是相当于java的一个中间件，浏览器发出HTTP请求后经过tomcat中间件，转发到目的服务器，目的服务器返回响应消息，通过tomcat返回给浏览器 

### http和servlet重温
> http协议分为请求协议和响应协议

**http请求协议部分数据**
```
GET /user HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
```
> 第一部分：请求行：请求类型，资源路径以及http版本（上述第一行）
> 第二部分：请求头：紧接在请求行之后，用于说明服务器需要使用的附加信息（第二到第八行） 
> 第三部分：空行（请求头和主体之间必须有换行） 
> 第四部分：主体数据，可以添加任意数据

**http响应协议**
```
HTTP/1.1 200
Content-Type：text/html
 
OK
```
> 第一部分：状态行，http版本，状态码，状态信息（第一行）
> 第二部分：响应报文头部，说明服务器需要用到的附加信息（第二行）
> 第三部分：空行（第三行）
> 第四部分：响应正文（第四行）

### Servlet的运行过程：

实例化Servlet

init方法进行初始化

当收到客户端请求信息时，调用service方法处理客户端请求，service会根据不同的请求类型，调用不同的doXXX()方法

销毁（servlet容器关闭时，实例也随之销毁）

## 理解客户端和服务器之间的通信
* 代码模拟（TomcatServerV1.java、Response.java）