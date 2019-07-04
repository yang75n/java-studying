package com.test.udp.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive implements Runnable {
    private DatagramSocket socket;

    public Receive(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buff = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buff, buff.length);
                System.out.println("等待接收");
                socket.receive(packet);
                System.out.println("收到了数据");
                String ip = packet.getAddress().getHostAddress();
                String data = new String(packet.getData(), 0, packet.getLength());
                if ("bye".equals(data)) {
                    System.out.println(ip + "离开了");
                }
                System.out.println(ip + "说" + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}