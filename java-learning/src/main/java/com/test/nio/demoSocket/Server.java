package com.test.nio.demoSocket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by iQiwen on 2019/3/29.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8089);

        while (true) {
            System.out.println("Server 启动");
            Socket socket = serverSocket.accept();

            byte data[] = new byte[1024];
            socket.getInputStream().read(data);

            System.out.println("Server 收到" + new String(data));
            socket.getOutputStream().write(data);
            socket.getOutputStream().flush();

            //TimeUnit.SECONDS.sleep(20);

        }
    }
}
