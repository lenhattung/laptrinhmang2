import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void copyFile(String src, String dest) {
        // Tao ra mot cai file moi
        // Tung buoc doc du lieu tu file cu => ghi sang file moi
        File fileSrc = new File(src); // 1
        File fileDest = new File(dest);// 2
        try {
            if (!fileSrc.exists()) {
                System.out.println("File src khong ton tai!");
            } else {
                if (fileDest.exists()) {
                    System.out.println("File dest da ton tai, ban co muon ghi de hay khong (y/n)?");
                    Scanner sc = new Scanner(System.in);
                    String c = sc.nextLine();
                    if (c.equals("n")) { // Neu khong muon ghi de thi ngung chuong trinh
                        return;
                    }
                } else {
                    fileDest.createNewFile();
                }

                // Tao stream de doc du lieu
                FileInputStream fis = new FileInputStream(fileSrc);

                // Tao stream ghi du lieu
                FileOutputStream fos = new FileOutputStream(fileDest);

                // Copy tung byte
                int b = 0;
                while(true){
                    b = fis.read(); // Doc len mot byet

                    if(b==-1) break; // =-1 khi khong co du lieu de doc

                    fos.write(b); // ghi xuong file
                    fos.flush(); // ep du lieu duoc ghi xuong file ngay lap tuc
                }
                fis.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileArr(String src, String dest) {
        // Tao ra mot cai file moi
        // Tung buoc doc du lieu tu file cu => ghi sang file moi
        File fileSrc = new File(src); // 1
        File fileDest = new File(dest);// 2
        try {
            if (!fileSrc.exists()) {
                System.out.println("File src khong ton tai!");
            } else {
                if (fileDest.exists()) {
                    System.out.println("File dest da ton tai, ban co muon ghi de hay khong (y/n)?");
                    Scanner sc = new Scanner(System.in);
                    String c = sc.nextLine();
                    if (c.equals("n")) { // Neu khong muon ghi de thi ngung chuong trinh
                        return;
                    }
                } else {
                    fileDest.createNewFile();
                }

                // Tao stream de doc du lieu
                FileInputStream fis = new FileInputStream(fileSrc);

                // Tao stream ghi du lieu
                FileOutputStream fos = new FileOutputStream(fileDest);

                // Copy moi lan 1MB
                byte[] arr = new byte[1024*1024];
                while(true){
                    int n = fis.read(arr); // Doc mot mang 1MB

                    if(n==-1) break; // =-1 khi khong co du lieu de doc

                    fos.write(arr, 0, n); // Doc duoc bao nhieu thi ghi dung bay nhieu du lieu
                    fos.flush(); // ep du lieu duoc ghi xuong file ngay lap tuc
                }
                fis.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String src = "C:\\Users\\tungi\\Downloads\\Buổi 01-20240315_070324-Meeting Recording.mp4";
        String dest = "D:\\Buổi 01-20240315_070324-Meeting Recording.mp4";
        // copyFile(src, dest);
        copyFileArr(src, dest);
    }
}
