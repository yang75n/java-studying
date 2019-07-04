package com.test.udp.unicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPClient {
    public static void main(String args[]) throws Exception {
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");//args[0]);
        int port = Integer.valueOf(8080);//args[1]);

        for (int i = 0; i < 100; ++i) {
            DatagramSocket clientSocket = new DatagramSocket();

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence = "Send: " + String.valueOf(i);
            System.out.println(sentence);
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("Received:" + modifiedSentence);
            clientSocket.close();

            Thread.sleep(1000);
        }
    }
}