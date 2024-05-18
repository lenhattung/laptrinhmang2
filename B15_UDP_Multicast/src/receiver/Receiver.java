package receiver;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver {
    private String ip;
    private int port;

    public Receiver(String ip, int port) {
        this.ip = ip;
        this.port = port;
        getMessage();
    }

    private void getMessage() {
        System.out.println("Đang nhận dữ liệu ");
        try {
            InetAddress ip_group = InetAddress.getByName(this.ip);
            MulticastSocket socket = new MulticastSocket(this.port);
            socket.joinGroup(ip_group);

            while(true){
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
