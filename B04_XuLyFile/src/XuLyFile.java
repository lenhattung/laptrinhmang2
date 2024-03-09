import java.io.File;
import java.io.IOException;

public class XuLyFile {
    public static void taoThuMuc(String path){
        // Khai bao ra file moi
        File file = new File(path);

        if(!file.exists()) { // exists => kiểm tra đã tồn tại hay chưa?
            // Tạo thư mục
            // file.mkdir(); // make directory
            file.mkdirs(); // tạo nhiều thư mục cùng lúc
        }else{
            System.out.println("Thư mục đã tồn tại!");
        }
    }
    public static void taoTapTin(String path){
        // Khai bao ra file moi
        File file = new File(path);

        if(!file.exists()) { // exists => kiểm tra đã tồn tại hay chưa?
            // Những tình huống lỗi nào có thể xảy ra
            /*
                1. Không quyền tạo tập tin
                2. Đường dẫn (path) không chính xác
                3. Không đủ dung lượng
             */
            try {
                file.createNewFile(); // Tạo ra một tập tin mới;
            }catch (IOException e){
                System.out.println("Gặp lỗi IO Exception!");
                e.printStackTrace();
            }
        }else{
            System.out.println("Tập tin đã tồn tại!");
        }
    }


    public static void main(String[] args) {
        // String path = "D:\\temp";
        // XuLyFile.taoThuMuc(path);

        // String path = "D:\\temp\\dir1\\dir2\\dir3";
        // XuLyFile.taoThuMuc(path);

        // String path = "D:\\temp\\BAITAP.DOCX";
        // XuLyFile.taoTapTin(path);

        String path = "D:\\temp\\baitap\\BAITAP.DOCX";
        XuLyFile.taoTapTin(path);
    }
}
