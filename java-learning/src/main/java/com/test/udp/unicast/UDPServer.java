package com.test.udp.unicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPServer {
    public static void main(String args[]) throws Exception {
        int recvPort = 8080;// Integer.valueOf(args[0]);
        DatagramSocket serverSocket = new DatagramSocket(recvPort);

        System.out.println("Receive on port " + recvPort);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("receive wait...");
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println("RECEIVED: " + IPAddress.getHostAddress() + ":" + port +
                    ", data:" + sentence);
            String clientSocketInfo = IPAddress.getHostAddress() + ":" + port;
            sendData = clientSocketInfo.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}