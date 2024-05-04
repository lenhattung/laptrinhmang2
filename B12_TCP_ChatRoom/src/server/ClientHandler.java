package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket mySocket;
    private ChatServer chatServer;
    private String sid;
    private InputStream input;
    private OutputStream output;

    public ClientHandler(Socket s, String id, ChatServer server){
        this.mySocket = s;
        this.sid = id;
        this.chatServer = server;

        try {
            this.input = mySocket.getInputStream();
            this.output = mySocket.getOutputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead=input.read(buffer))!=-1){
                String message = new String(buffer, 0, bytesRead);
                chatServer.broadcastMessage(this.sid, message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String ms){
        try {
            output.write(ms.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getSid() {
        return this.sid;
    }
}
