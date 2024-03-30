import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {

    public static void main(String[] args) {
//        String fileURL = "https://vcdn-giaitri.vnecdn.net/2024/03/30/tai-xuong-11-8170-1711780755.png";
        String fileURL = "https://vnexpress.net/loat-co-vat-trieu-nguyen-sap-duoc-dau-gia-4728493.html";
        String saveDir = "D:\\Download";

        try {
            URL url = new URL(fileURL);
            // Tạo kết nối để đọc/ghi dữ liệu
            URLConnection connection = url.openConnection();
            // Lấy InputStream từ kết nối
            InputStream is = connection.getInputStream();
            // Lấy tên file
            String fileName = fileURL.substring(fileURL.lastIndexOf("/")+1);
            // Kiểm tra thư mục
            File directory = new File(saveDir);
            if(!directory.exists()){
                directory.mkdirs();
            }
            // Tạo ra FileOutputStream \\ /
            FileOutputStream fos = new FileOutputStream(saveDir + File.separator +fileName);
            int bytesRead;
            byte[] buffer = new byte[4096];
            while((bytesRead=is.read(buffer))!=-1){
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File download successfully!");
            fos.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
