import java.net.NetworkInterface;
import java.util.Enumeration;

public class InterfaceLister {
    public static void main(String[] args) {
        try {
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            // Kiem tra con interface nao khac hay khong
            while (interfaces.hasMoreElements()){
                // Lay ra phan tu và ep kieu
                NetworkInterface ni = (NetworkInterface)interfaces.nextElement();
                System.out.println(ni);
            }
        }catch(Exception e){
            System.out.println("Gặp lỗi");
        }
    }
}
