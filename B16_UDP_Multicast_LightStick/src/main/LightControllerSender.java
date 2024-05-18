package main;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class LightControllerSender {
    private String ip;
    private int port;

    public LightControllerSender(String ip, int port) {
        this.ip = ip;
        this.port = port;

        sendMessage();
    }

    private void sendMessage() {
        try {
            InetAddress group = InetAddress.getByName(this.ip);
            MulticastSocket socket = new MulticastSocket();

            String[] colors = {"Red", "Green", "Blue"};
            int colorIndex = 0;

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Bạn muốn chọn màu nào:");
                System.out.println("0. Red");
                System.out.println("1. Green");
                System.out.println("2. Blue");

                colorIndex = scanner.nextInt();
                // scanner.nextLine();
                if(colorIndex>2 || colorIndex<0)
                    colorIndex=0;

                String message = colors[colorIndex];
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, this.port);
                socket.send(sendPacket);

                Thread.sleep(1000); // Đợi một khoảng thời gian trước khi thay đổi màu đèn
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
