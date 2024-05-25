package server;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Desktop
 */
public class Server {
    public static void main(String[] args) {
        try {
            // Tạo ra thanh ghi ở server
            Registry registry = LocateRegistry.createRegistry(1099);

            // Tạo calculator
            CalculatorInterface calculatorSkeleton = new CalculatorImpl();

            // Đăng ký object cho thanh ghi
            registry.rebind("Calculator", (Remote) calculatorSkeleton);

            while(true)           {
                System.out.println("Server is running ... ");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
        }
    }
}