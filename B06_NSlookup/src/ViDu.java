import java.net.InetAddress;

public class ViDu {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("www.facebook.com");
            // Trả về đối tượng
            System.out.println(ia.getAddress());
            // Trả về IP
            System.out.println(ia.getHostAddress());
            // Trả về IP
            System.out.println(ia.getCanonicalHostName());
            // Trả về domain name
            System.out.println(ia.getHostName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
