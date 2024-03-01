### 上步回顾
上面的代码虽然做到了服务器和客户端的通信，但是有个弊端，服务器一次只能连接一个客户端。
tomcat在解决这个问题时使用了BIO模型，简单来讲就是每个连接一个线程，下面就来实现BIO：

### 使用BIO模型解决稚嫩连接一次的弊端（代码见TomcatServerV2.java）