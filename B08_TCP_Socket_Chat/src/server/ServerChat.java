package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
    public static void main(String[] args) {
        try {
            // Tạo ra server socket
            ServerSocket server = new ServerSocket(25000);
            System.out.println("Server đang chạy tại port: 25000");

            while (true) {
                Socket connection = server.accept();
                System.out.println("Chấp nhận kết nối từ client");

                // Lấy stream đọc dữ liệu
                InputStream is = connection.getInputStream();
                // Lấy stream để ghi dữ liệu
                OutputStream os = connection.getOutputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

                System.out.println("-------------------------");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhập 'exit' để thoát");
                System.out.println("Nhập nội dung tin nhắn để gửi thông tin đến client");
                while (true) {
                    // Đọc dữ liệu từ client va xuat ra man hinh
                    System.out.println(br.readLine());

                    // Server doc tin nhan tu ban phim

                    String input = scanner.nextLine();
                    if (input.equals("exit")) {
                        break;
                    }
                    // Gui tin nhan den client
                    pw.println("Server: " + input);
                    // Ep buoc du lieu truyen di ngay lap tuc
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
