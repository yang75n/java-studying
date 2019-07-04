package com.test.udp.broadcast;

import java.net.DatagramSocket;
import java.net.SocketException;


public class Main {
    public static void main(String args[]) throws SocketException {
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket reveSocket = new DatagramSocket(10001);
        new Thread(new Send(sendSocket)).start();
        new Thread(new Receive(reveSocket)).start();
    }
}