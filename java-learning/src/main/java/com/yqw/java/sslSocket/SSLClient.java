package com.yqw.java.sslSocket;

import java.io.*;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


/**
 * 通过程序的错误输出，我们能够发现 SSL 建立失败了，
 * 在握手阶段双方没有能够协商出加密方法等信息。这是因为默认情况下，
 * java 虚拟机没有与 SSL 相关的配置，需要开发者自己按照文档进行一些配置。
 * 在 JDK 中提供了一个安全钥匙与证书的管理工具 Keytool。Keytool 把钥匙，
 * 证书以及和与它们相关联的证书链储存到一个 keystore 中，默任的实现 keystore 的是一个文件，
 * 它本身有一个访问密码来保护存储在其中的内容。就本样例程序而言，
 * 只需要配置客户端和服务器端双方信任就可以了。可以按照如下几步来完成：
 * <p>
 * 1. 进入本地的 java 安装位置的 bin 目录中 cd /java/bin
 * <p>
 * 2. 创建一个客户端 keystore 文件，如图 2 所示
 * <p>
 * keytool -genkey -alias sslclient -keystore sslclientkeys
 * <p>
 * <p>
 * <p>
 * https://www.cnblogs.com/hua198/p/5223883.html
 */
class SSLClient {

    private SSLSocket socket = null;

    public SSLClient() throws IOException {
        // 通过套接字工厂，获取一个客户端套接字
        SSLSocketFactory socketFactory = (SSLSocketFactory)
                SSLSocketFactory.getDefault();
        //  socket = (SSLSocket) socketFactory.createSocket("www.baidu.com", 443);
        socket = (SSLSocket) socketFactory.createSocket("localhost", 7070);

    }

    public void connect() {
        try {
            // 获取客户端套接字输出流
            PrintWriter output = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            // 将用户名和密码通过输出流发送到服务器端
            String userName = "principal";
            output.println(userName);
            String password = "credential";
            output.println(password);
            output.flush();

            // 获取客户端套接字输入流
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // 从输入流中读取服务器端传送的数据内容，并打印出来
            String response = input.readLine();
            response += "\n " + input.readLine();
            System.out.println(response);

            // 关闭流资源和套接字资源
            output.close();
            input.close();
            socket.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public static void main(String args[]) throws IOException {
        new SSLClient().connect();
    }
}