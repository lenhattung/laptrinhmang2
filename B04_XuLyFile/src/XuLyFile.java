import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XuLyFile {
    public static void taoThuMuc(String path) {
        // Khai bao ra file moi
        File file = new File(path);

        if (!file.exists()) { // exists => kiểm tra đã tồn tại hay chưa?
            // Tạo thư mục
            // file.mkdir(); // make directory
            file.mkdirs(); // tạo nhiều thư mục cùng lúc
        } else {
            System.out.println("Thư mục đã tồn tại!");
        }
    }

    public static void taoTapTin(String path) {
        // Khai bao ra file moi
        File file = new File(path);

        if (!file.exists()) { // exists => kiểm tra đã tồn tại hay chưa?
            // Những tình huống lỗi nào có thể xảy ra
            /*
                1. Không quyền tạo tập tin
                2. Đường dẫn (path) không chính xác
                3. Không đủ dung lượng
             */
            try {
                file.createNewFile(); // Tạo ra một tập tin mới;
            } catch (IOException e) {
                System.out.println("Gặp lỗi IO Exception!");
                e.printStackTrace();
            }
        } else {
            System.out.println("Tập tin đã tồn tại!");
        }
    }

    public static void xoa(String path) {
        File file = new File(path);

        if (file.exists()) {
            file.delete(); // => xóa (nếu là thư mục có nội dung bên trong sẽ không xóa được)
            // file.deleteOnExit(); // xóa nếu tập tin có tồn tài
        } else {
            System.out.println("Tập tin/ Thư mục không tồn tại!");
        }
    }

    public static void xoaTatCa(String path) {
        File file = new File(path);

        if (file.exists()) {
            // sử dụng đệ quy
            if (file.isDirectory()) { // nếu file là thư mục
                // Xóa nội dung bên trong
                File[] files = file.listFiles(); // Lấy ra danh sách các file con
//                for(int i=0; i<files.length; i++){
//                    File f = files[i];
//                }
                for (File f : files) { // foreach
                    xoaTatCa(f.getAbsolutePath()); // Tiếp tục đệ quy để xóa dựa trên đường dẫn tuyệt đối
                }
            }

            // (ax - bx) = 0 <=> x(a-b) = 0

            // Xóa chính bản thân nó
            if(file.delete()){ // thực hiện hành động xóa và kiểm tra thành công
                System.out.println("Đã xóa file: " + path);
            }else{
                System.out.println("Không thể xóa file: " + path);
            }
        } else {
            System.out.println("Tập tin/ Thư mục không tồn tại!");
        }
    }

    public static void hienThiCayThuMucChiTiet(String path, int level){
        File file = new File(path);

        for (int i=0; i<level; i++){
            System.out.print("\t");
        }
        if(file.isFile()) { // Kiểm tra file là tập tin
            System.out.println("|__" +file.getName()); // Lấy ra tên file
        }else{
            System.out.println("|__" +file.getName()); // Lấy ra tên file

            // Tiếp tục đệ quy để hiện thị các mục con bên trong
            File[] files = file.listFiles();
            for(File f: files){
                hienThiCayThuMucChiTiet(f.getAbsolutePath(), level+1);
            }
        }
    }

    public static void hienThiCayThucMuc(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File không tồn tại");
            return; // Dừng lương hàm
        }


        hienThiCayThuMucChiTiet(path, 0);
    }

    public static void kiemTraThongTin(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File không tồn tại");
            return; // Dừng lương hàm
        }
        System.out.println("THÔNG TIN CHI TIẾT: ");
        System.out.println("Tên file: " + file.getName());
        System.out.println("Loại: " + (file.isFile()?"Tập tin":"Thư mục"));
        // System.out.println("Lưu trữ: " + file.getTotalSpace());
        System.out.println("File ẩn: " + file.isHidden());
    }

    public static void main(String[] args) {
        // String path = "D:\\temp";
        // XuLyFile.taoThuMuc(path);

        // String path = "D:\\temp\\dir1\\dir2\\dir3";
        // XuLyFile.taoThuMuc(path);

        // String path = "D:\\temp\\BAITAP.DOCX";
        // XuLyFile.taoTapTin(path);

        // String path = "D:\\temp\\baitap\\BAITAP.DOCX";
        // XuLyFile.taoTapTin(path);

        //String path = "D:\\temp - Copy\\BAITAP.DOCX";
        //XuLyFile.xoa(path);

        //String path = "D:\\temp - Copy";
        //XuLyFile.xoa(path);

        // String path = "D:\\temp - Copy\\dir1\\dir2\\dir3";
        // XuLyFile.xoa(path);

        // String path = "D:\\temp - Copy";
        // XuLyFile.xoaTatCa(path);

        // XuLyFile.hienThiCayThucMuc("D:\\temp");

        XuLyFile.kiemTraThongTin("D:\\temp");
    }
}
