import java.net.URL;

public class ViDuURL {
    public static void main(String[] args) {
        try {
            // URL u = new URL("https://vnexpress.net/chu-truong-quoc-te-my-keu-goi-phu-huynh-dong-them-125-ty-dong-4728486.html");
            URL u = new URL("https://titv.vn/wp-content/uploads/2022/08/Screenshot-2023-01-29-230321.png");
            System.out.println("Protocol: " + u.getProtocol());
            System.out.println("Host: " + u.getHost());
            System.out.println("Port: " + u.getPort());
            System.out.println("File: " + u.getFile());
            System.out.println("Ref: " + u.getRef());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
