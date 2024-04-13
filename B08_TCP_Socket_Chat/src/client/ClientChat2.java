package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat2 {
    public static void main(String[] args) {
        try {
            // Địa chỉ server: 127.0.0.1
            // Zalo địa chỉ server: zalo.vn
            Socket client = new Socket("127.0.0.1", 25000);
            System.out.println("Đã kết nối đến máy chủ");


            // Lấy stream đọc dữ liệu
            InputStream is = client.getInputStream();
            // Lấy stream để ghi dữ liệu
            OutputStream os = client.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

            // Gửi câu xin chào & ghi thông tin
            pw.println("Client: Xin chào, tôi là là Client");
            pw.flush();

            System.out.println("-------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập 'exit' để thoát");
            System.out.println("Nhập nội dung tin nhắn để gửi thông tin đến client");
            while(true){
                // Đọc dữ liệu từ server va xuat ra man hinh
                System.out.println(br.readLine());

                // Server doc tin nhan tu ban phim

                String input = scanner.nextLine();
                if (input.equals("exit")){
                    break;
                }
                // Gui tin nhan lên server
                pw.println("Client: "+ input);
                // Ep buoc du lieu truyen di ngay lap tuc
                pw.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
