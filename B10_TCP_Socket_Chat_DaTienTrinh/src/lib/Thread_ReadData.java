package lib;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Thread_ReadData extends Thread {
    private Socket socket;
    private String name;

    public Thread_ReadData(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Lấy stream đọc dữ liệu
            InputStream is = socket.getInputStream();
            // Tạo reader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while (true) {
                // Đọc dữ liệu từ client va xuat ra man hinh
                System.out.println(name+" : "+br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
