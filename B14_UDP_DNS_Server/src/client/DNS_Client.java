package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DNS_Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            Scanner scanner = new Scanner(System.in);
            while(true){
                // Đọc địa chỉ IP cần tra cứu
                System.out.println("Nhập vào tên miền cần tra cứu địa chỉ IP: ");
                String domain = scanner.nextLine();

                // Gửi truy vấn
                byte[] sendData = domain.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);

                // Nhận phản hồi
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Xuất kết quả
                String ip = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(ip);
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
