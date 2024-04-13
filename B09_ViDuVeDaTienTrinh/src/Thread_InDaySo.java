public class Thread_InDaySo extends Thread {
    public String ten;

    public Thread_InDaySo(String ten) {
        this.ten = ten;
    }

    public void xuatDaySo(){
        long i = 0;
        while(true){
            System.out.println(ten +" : " +i);
            i++;
            if(i>10000000)
                break;
        }
    }

    @Override
    public void run() {
        xuatDaySo();
    }
}
