import java.net.InetAddress;
import java.util.Scanner;

public class MyNSLookup {
    public static void main(String[] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhập vào domain name/ip để tra ứu thống tin.");
            System.out.println("Nhập vào 'exit' để thoát.");
            input = sc.nextLine();
            // Thoát vòng lặp nếu gặp "exit"
            if(input.equals("exit"))
                break;

            // In thông tin
            try {
                InetAddress ia = InetAddress.getByName(input);
                // in thông tin
                System.out.println("IP: "+ia.getHostAddress());
                System.out.println("Domain: "+ia.getHostName());
            }catch (Exception e){
                //e.printStackTrace();
                System.out.println("Gặp lỗi, vui lòng nhập địa chỉ khác!");
            }
        }
    }
}
