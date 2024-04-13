package client;

import lib.Thread_ReadData;
import lib.Thread_WriteData;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
        try {
            // Địa chỉ server: 127.0.0.1
            // Zalo địa chỉ server: zalo.vn
            Socket client = new Socket("127.0.0.1", 25000);
            System.out.println("Đã kết nối đến máy chủ");

            Thread_ReadData tr = new Thread_ReadData(client, "Server");
            Thread_WriteData tw = new Thread_WriteData(client, "Server");

            tr.start();
            tw.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
