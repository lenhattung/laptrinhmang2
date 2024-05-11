package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DNS_Server {
    public static void main(String[] args) {
        // Gia lap mot dnsTable
        String[][] dnsTable= {
            {"www.example.com","192.168.1.100"},
            {"www.google.com","8.8.8.8"},
            {"www.titv.vn","9.1.9.1"}
        };

        try {
            // Tao DatagramSocket
            DatagramSocket socket = new DatagramSocket(9876);

            // Lien tuc lang nghe tu client
            while(true){
                // Tao va nhan goi tin tu Client
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Truy van IP tu dnsTable
                String domainName = new String(receivePacket.getData(), 0, receivePacket.getLength());
                domainName = domainName.trim();
                domainName = domainName.toLowerCase();

                // Duyet toan bo cai table
                String result = "Not found!";
                for (String[] entry: dnsTable) {
                    if(entry[0].equals(domainName)){
                        result = entry[1];
                        break;
                    }
                }

                // Phản hồi thông tin cho Client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                byte[] responseData = result.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
