import java.net.InetAddress;

public class LocalHostInfo {
    public static void main(String[] args) {
        try {
            // Tạo địa inet cho máy thiết bị
            InetAddress ia = InetAddress.getLocalHost();
            // Trả về tên
            System.out.println("My name is: " + ia.getHostName());
            // Trả về tên
            System.out.println("My address is: " + ia.getHostAddress());
            
            // 
            byte[] address = ia.getAddress();
            for (int i = 0; i < address.length; i++) {
                System.out.println(address[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
