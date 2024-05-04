package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientWrite extends Thread{
    private Socket socket;
    private OutputStream outputStream;

    public ClientWrite(Socket socket){
        this.socket = socket;
        try {
            this.outputStream = this.socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            while (true){
                String message = sc.nextLine();
                outputStream.write(message.getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
