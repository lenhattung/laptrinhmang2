package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 5000;
    private List<ClientHandler> clients = new ArrayList<>();

    public ChatServer(){
        try {
            // websocket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port: " + PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis()+"", this);
                clients.add(clientHandler);
                clientHandler.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void broadcastMessage(String id, String ms){
        for (ClientHandler client: clients){
            if(!(client.getSid().equals(id))){
                client.sendMessage(id+" : "+ ms);
            }
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
    }
}
