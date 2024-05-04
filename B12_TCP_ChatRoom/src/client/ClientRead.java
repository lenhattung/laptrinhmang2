package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientRead extends  Thread{
    private Socket socket;
    private InputStream inputStream;

    public ClientRead(Socket socket){
        this.socket = socket;
        try {
            this.inputStream = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead=inputStream.read(buffer))!=-1){
                String message = new String(buffer, 0, bytesRead);
                System.out.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
