package server;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class HandleRequest extends Thread{
    private Socket socket;

    public HandleRequest(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
       try{
           InputStream is = socket.getInputStream();
           OutputStream os = socket.getOutputStream();

           BufferedReader reader = new BufferedReader(new InputStreamReader(is));
           PrintWriter writer = new PrintWriter(os);

           while(true){
               // Đọc yêu cầu
               String request = reader.readLine();
               System.out.println(request);
               if(request.equals("shutdown")){
                   // Sử dụng dụng Runtime
                   Runtime.getRuntime().exec("shutdown -s -t 3600");
               }else if (request.equals("restart")){
                   // Sử dụng dụng Runtime
                   Runtime.getRuntime().exec("shutdown -r -t 3600");
               }else if (request.equals("cancel")){
                   // Sử dụng dụng Runtime
                   Runtime.getRuntime().exec("shutdown -a");
               }else if (request.equals("screenshot")){
                   Robot robot = new Robot();
                   // Chụp ảnh
                   BufferedImage screenshot =  robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

                    // Tạo mảng dữ liệu
                   ByteArrayOutputStream baos = new ByteArrayOutputStream();
                   ImageIO.write(screenshot, "png", baos);
                   byte[] imageBytes = baos.toByteArray();
                   baos.close();

                   // Ghi dữ liệu từ baos sang client
                   writer.println(imageBytes.length);
                   writer.flush();
                   os.write(imageBytes);
                   os.flush();
               }
           }

       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
