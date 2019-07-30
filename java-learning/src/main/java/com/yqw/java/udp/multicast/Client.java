package com.yqw.java.udp.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		String host = "224.0.0.1";// 多播地址
		int port = 9998;
		String message = "yqw-multicastSocket";
		try {
			InetAddress group = InetAddress.getByName(host);
			MulticastSocket s = new MulticastSocket();
			// 加入多播组
			s.joinGroup(group);
			DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), group, port);
			System.out.println("客户端发送...");
			s.send(dp);
			System.out.println("客户端发送成功");
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
