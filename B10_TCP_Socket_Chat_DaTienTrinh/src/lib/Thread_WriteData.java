package lib;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Thread_WriteData extends Thread{
    private Socket socket;
    private String name;

    public Thread_WriteData(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {
// Lấy stream để ghi dữ liệu
            OutputStream os = socket.getOutputStream();
            System.out.println("-------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập 'exit' để thoát");
            System.out.println("Nhập nội dung tin nhắn để gửi thông tin đến client");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            while (true) {
                // Server doc tin nhan tu ban phim
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }
                // Gui tin nhan den client
                pw.println(input);
                // Ep buoc du lieu truyen di ngay lap tuc
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
