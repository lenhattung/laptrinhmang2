package sender;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender {
    private String ip;
    private int port;

    public Sender(String ip, int port) {
        this.ip = ip;
        this.port = port;
        sendMessage();
    }

    private void sendMessage() {
        System.out.println(this.ip +" đang gửi dữ liệu!");
        try {
            InetAddress ip_group = InetAddress.getByName(this.ip);
            MulticastSocket socket = new MulticastSocket();

            while ((true)){
                String msg = "Chào bạn, bạn đang nhận dữ lệu từ: "+this.ip+" "+ System.currentTimeMillis();
                byte[] sendData = msg.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip_group, this.port);
                socket.send(sendPacket);
                Thread.sleep(2000);
            }
        }catch (Exception e){

        }
    }

}
