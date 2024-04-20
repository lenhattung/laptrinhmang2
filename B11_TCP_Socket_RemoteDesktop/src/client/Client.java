package client;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 29999);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(os);

            Scanner sc = new Scanner(System.in);
            boolean exit = false;

            while(!exit){
                System.out.println("--------------");
                System.out.println("CHỌN LỆNH");
                System.out.println("1. shutdown");
                System.out.println("2. restart");
                System.out.println("3. cancel");
                System.out.println("4. Screenshot");
                System.out.println("5. exit");

                int choice = sc.nextInt();
                sc.nextLine();

                System.out.println("Bạn đã chọn: "+choice);
                switch (choice) {
                    case 1:
                        writer.println("shutdown");
                        writer.flush();
                        break;
                    case 2:
                        try {
                            writer.println("restart");
                            writer.flush();
                            break;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    case 3:
                        writer.println("cancel");
                        writer.flush();
                        break;
                    case 4:
                        // Ra lệnh cho server
                        writer.println("screenshot");
                        writer.flush();
                        // Đọc dữ liệu từ socket và ghi xuống ổ cứng
                        int imageSize = Integer.parseInt(reader.readLine());
                        byte[] imageBytes = new byte[imageSize];
                        int quantityOfByte =  is.read(imageBytes);
                        if(quantityOfByte>0){
                            System.out.println("Nhập tên ảnh: ");
                            String fileName = sc.nextLine();
                            Path imgPath = Paths.get(fileName+".png");
                            Files.write(imgPath, imageBytes);
                            System.out.println("Done!");
                        }
                        break;
                    case 5:
                        exit = true;
                    default:
                        throw  new AssertionError();
                }
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
