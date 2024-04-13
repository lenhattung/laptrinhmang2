public class Thread_Test {
    public static void main(String[] args) {
        Thread_InDaySo  inDaySoA = new Thread_InDaySo("A");
        Thread_InDaySo inDaySoB = new Thread_InDaySo("B");

        // Bắt đầu tiến trình A
        inDaySoA.start();
        // Bắt đầu tiến trình B
        inDaySoB.start();

        // A va B độc lập, có quyền chạy song song

    }
}
