package server;

import java.net.ServerSocket;
import java.net.Socket;

public class RemoteSerrver {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(29999);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: "+ socket.getInetAddress().getHostAddress());
                HandleRequest hr = new HandleRequest(socket);
                hr.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
