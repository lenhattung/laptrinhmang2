import java.io.*;

public class ReadTxtFile {
    public static void main(String[] args) {
        try {
            String src = "D:\\OneDrive\\Documents\\GitHub\\laptrinhmang2\\B05_LuongDuLieu\\src\\vidu.txt";
            File file = new File(src); // Buoc 1
            // Tạo Inputstream
            InputStream is = new FileInputStream(file);
            // Tạo InputStreamReader
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            // Tạo BufferedReader
            BufferedReader br = new BufferedReader(isr);
            // Đọc dữ liệu
            while(true){
                String line = br.readLine(); // Đọc 1 dòng
                if (line==null) break; // Nếu không có dữ liệu
                System.out.println(line); // Xuất ra màn hình
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
