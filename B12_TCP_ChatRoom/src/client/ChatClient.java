package client;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    private static final String URL = "localhost";
    private static final int PORT = 5000;

    public ChatClient(){
        try {
            Socket socket = new Socket(URL, PORT);
            System.out.println("Đã kết nối được đến server");

            // Liên tục đọc dữ liệu từ server
            ClientRead clientRead = new ClientRead(socket);
            clientRead.start();

            // Liên tục gửi du lieu
            ClientWrite clientWrite = new ClientWrite(socket);
            clientWrite.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
    }
}
