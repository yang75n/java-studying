package com.yqw.java.nio.demoSocket;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by iQiwen on 2019/3/29.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Client 启动");
        Socket socket = new Socket();
        socket.setSoTimeout(10000);
        socket.connect(new InetSocketAddress("localhost", 8089),2000);
        System.out.println("Client连接成功");
        socket.getOutputStream().write("nihao".getBytes());
        byte data[] = new byte[24];
        socket.getInputStream().read(data);
        System.out.println("Client 收到" + new String(data));


    }
}

