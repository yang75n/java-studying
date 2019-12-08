package com.yqw.java.udp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatClient extends JFrame {

    JTextArea contents = new JTextArea();
    JLabel label1 = new JLabel("服务器地址");
    JTextField address = new JTextField();
    JLabel label2 = new JLabel("用户名");
    JTextField username = new JTextField();
    JButton online = new JButton("上线");
    JButton offline = new JButton("下线");
    JTextField input = new JTextField();
    JButton send = new JButton("发送");

    boolean onlineFlag = false;

    public ChatClient() {
        super("Chat Client");

        contents.setEditable(false);
        getContentPane().add(contents);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEADING));

        address.setPreferredSize(new Dimension(100, 28));
        username.setPreferredSize(new Dimension(80, 28));
        input.setPreferredSize(new Dimension(180, 28));

        p1.add(label1);
        p1.add(address);
        p1.add(label2);
        p1.add(username);
        p1.add(online);
        p1.add(offline);
        p1.add(input);
        p1.add(send);

        offline.setEnabled(false);
        send.setEnabled(false);

        getContentPane().add(p1, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                onlineFlag = false;
                Map<String, Object> m1 = new HashMap<String, Object>();
                m1.put("time", new Date()); // 上线时间
                m1.put("username", getUsername());
                m1.put("onlineFlag", onlineFlag);

                send(getServerAddress(), 2222, m1);

                System.exit(0);
            }
        });

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String server = getServerAddress();
                if (server == null || server.length() == 0) {
                    JOptionPane.showMessageDialog(ChatClient.this, "请输入服务器地址！");
                    return;
                }

                if (ae.getSource() == online) {
                    // 用户点击了上线按钮
                    if (!onlineFlag) {
                        onlineFlag = true;
                        Map<String, Object> m1 = new HashMap<String, Object>();
                        m1.put("time", new Date()); // 上线时间
                        m1.put("username", getUsername());
                        m1.put("onlineFlag", onlineFlag);
                        online.setEnabled(false);
                        offline.setEnabled(true);
                        send.setEnabled(true);
                        address.setEnabled(false);
                        username.setEnabled(false);
                        send(getServerAddress(), 2222, m1);

                    }
                } else {
                    // 用户点击了下线按钮
                    if (onlineFlag) {
                        onlineFlag = false;
                        Map<String, Object> m1 = new HashMap<String, Object>();
                        m1.put("time", new Date()); // 上线时间
                        m1.put("username", getUsername());
                        m1.put("onlineFlag", onlineFlag);
                        online.setEnabled(true);
                        offline.setEnabled(false);
                        send.setEnabled(false);
                        address.setEnabled(true);
                        username.setEnabled(true);
                        send(getServerAddress(), 2222, m1);
                    }
                }
            }
        };

        ActionListener al2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Map<String, Object> m1 = new HashMap<String, Object>();
                m1.put("time", new Date());
                m1.put("username", getUsername());
                m1.put("input", getInput());
                send(getServerAddress(), 2222, m1);
            }
        };

        send.addActionListener(al2);

        online.addActionListener(al);
        offline.addActionListener(al);

        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 400);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((d.width - 720) / 2, (d.height - 400) / 2);
        setVisible(true);

        new Thread() {
            public void run() {
                try {
                    // 在2221端口接收服务器发送过来的聊天内容，包括上线，下线消息。
                    DatagramSocket rSocket = new DatagramSocket(2220);
                    while (true) {
                        byte[] buffer = new byte[1024 * 16];
                        DatagramPacket recvPacket = new DatagramPacket(buffer, buffer.length);
                        rSocket.receive(recvPacket);
                        byte[] data = recvPacket.getData();
                        byte[] recvData = new byte[recvPacket.getLength()];
                        System.arraycopy(buffer, 0, recvData, 0, recvData.length);
                        //将从服务器接收的数据存入Map并显示
                        Map<String, Object> map = convertByteArrayToMap(recvData);
                        if (map.containsKey("onlineFlag")) { // 上线或者下线
                            boolean b = (boolean) map.get("onlineFlag");
                            if (b) { // 上线
                                map.put("input", "上线");
                            } else { // 下线
                                map.put("input", "下线");
                            }
                        }
                        Date time = (Date) map.get("time");
                        String s = convertDateToFormatString(time);
                        String user = (String) map.get("username");
                        user = "[" + user + "]";
                        contents.append(s + user + ": " + (String) map.get("input") + "\r\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

    public String getServerAddress() {
        String s = address.getText();
        //trim删除多余空格
        s = s.trim();
        return s;
    }

    public String getUsername() {
        String s = username.getText();
        s = s.trim();
        if (s == null || s.length() == 0) {
            s = "匿名";
        }
        return s;
    }

    public String getInput() {
        String s = input.getText();
        s = s.trim();
        if (s == null || s.length() == 0) {
            s = "不想说什么";
        }
        return s;
    }

    public static String convertDateToFormatString(Date d) {
        return new java.text.SimpleDateFormat("(yyyy-MM-dd HH:mm:ss)").format(d);
    }

    public static void send(String ip, int port, Map<String, Object> map) {
        try {
            byte[] data = convertMapToByteArray(map);
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(data, data.length);

            packet.setSocketAddress(new InetSocketAddress(ip, port));
            socket.send(packet);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static byte[] convertMapToByteArray(Map<String, Object> map) {
        try {
            //完成此代码块，要求将map集合中的数据转换成字节数组
            
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream ois = new ObjectOutputStream(b);
            ois.writeObject(map);
            byte[] temp = b.toByteArray();
            return temp;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> convertByteArrayToMap(byte[] data) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Map<String, Object> result = (Map<String, Object>) ois.readObject();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new ChatClient();
    }

}