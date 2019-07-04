package com.test.udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatServer {

    LinkedBlockingQueue<Map<String, Object>> queue = new LinkedBlockingQueue<Map<String, Object>>();
    Set<String> onlineIPs = new HashSet<String>(); // 当前在线IP。

    public ChatServer() {
        try {

            new Thread() {
                public void run() {
                    while (true) {
                        try {
                            //补齐程序，要求从接收队列中取出数据，遍历在线IP集合，向所有在线IP发送数据

                            if( !queue.isEmpty() ){
                                if( !onlineIPs.isEmpty() ){
                                    for(String ip : onlineIPs){
                                        //下面的端口号可以自定义增加，初始转发至2220端口   多增加的端口可以实现本机内的广播
                                        ChatClient.send(ip, 2221, queue.peek() );
                                        ChatClient.send(ip, 2220, queue.remove() );
                                    }    
                                }
                            }
                            
                            //end
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            //接受端口2222
            DatagramSocket serverSocket = new DatagramSocket(2222);
            System.out.println("Chat Server started.");
            while (true) {
                byte[] buffer = new byte[1024 * 16];
                DatagramPacket recvPacket = new DatagramPacket(buffer, buffer.length);

                serverSocket.receive(recvPacket);

                InetSocketAddress remoteAddress = new InetSocketAddress(recvPacket.getAddress(),
                        recvPacket.getPort());
                System.out.println("接收到 " + remoteAddress.getHostString() + " 发送过来的数据包");

                byte[] data = recvPacket.getData();
                byte[] recvData = new byte[recvPacket.getLength()];
                System.arraycopy(buffer, 0, recvData, 0, recvData.length);
                System.out.println(recvData.length);
                Map<String, Object> map = ChatClient.convertByteArrayToMap(recvData);
                System.out.print("map长度"+map.size());
                if (map.containsKey("onlineFlag")) { // 上线或者下线
                    boolean b = (boolean) map.get("onlineFlag");
                    if (b) { // 上线
                        onlineIPs.add(remoteAddress.getHostString());
                    } else { // 下线
                        onlineIPs.remove(remoteAddress.getHostString());
                    }
                }

                queue.add(map);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }

}