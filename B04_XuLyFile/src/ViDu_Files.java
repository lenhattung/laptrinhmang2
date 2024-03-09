import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ViDu_Files {
    public static void main(String[] args) {
        // Copy
        Path source = Paths.get("D:\\OneDrive\\Teaching\\DNTU\\GiangDay\\LapTrinhMang\\LẬP TRÌNH MẠNG-20240101T075038Z-001\\LẬP TRÌNH MẠNG\\Bai 00 GIOI THIEU.pptx");
        Path newdir = Paths.get("D:\\temp");
        try {
            Files.copy(source, newdir.resolve(source.getFileName()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
