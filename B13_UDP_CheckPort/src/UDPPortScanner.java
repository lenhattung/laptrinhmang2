import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPPortScanner {
    public static void main(String[] args) {
        // Kiem tung port
        for(int port=1024; port<=65535; port++){
            try {
                // Kiểm tra port có được dùng hay chưa bằng cách tạo ra một DatagramSocket
                DatagramSocket server = new DatagramSocket(port);

                // Tao thanh cong => port truoc day chua duoc su dung
                server.close();
            }catch (SocketException ex){
                System.out.println("Port: "+ port +" dang duoc su dung!");
            }
        }
    }
}
