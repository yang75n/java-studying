package com.test.udp.broadcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 *
 * 编写一个聊天的工具 有收数据部分，和发数据部分 这两个不部分同时执行 就需要多线程技术 一个线程控制收，一个线程控制发
 *
 * 因为收和发动作是不一致的，所以要定义两个方法 而且这两个方法要封装到不同的类中
 *
 * @author 言曌
 * @date 2017/12/6 下午8:25
 * 
 * 
 * 
 */
class Send implements Runnable {

	/*
     * 广播比较好理解，我这里的局域网网络地址是 192.168.168.0
	 * 
	 * 所以 ip 为 192.168.168.1 - 192.168.168.254 是一个本局域网内的有效 ip 地址
	 * 
	 * 192.168.168.255 被称为广播地址，只要给广播地址发消息，该局域网内的所有人都能收到。
	 */
	private DatagramSocket socket;

	public Send(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			System.out.println("请输入:");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println("your input is =" + line);
				byte[] buff = line.getBytes();
				DatagramPacket packet = new DatagramPacket(buff, buff.length, InetAddress.getByName("172.21.255.255"),
						10001);
				System.out.println("发送...");
				socket.send(packet);
				if ("bye".equals(line)) {
					System.out.println("退出发送");
					break;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
