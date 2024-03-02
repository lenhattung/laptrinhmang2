import java.util.Scanner;

public class Vd4 {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap x: ");
        x = scanner.nextInt();

        String check = (x%2==0)?"So chan":"So le";
        System.out.println(check);
    }
}
