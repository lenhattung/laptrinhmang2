public class InDaySo {
    public String ten;

    public InDaySo(String ten) {
        this.ten = ten;
    }

    public void xuatDaySo(){
        long i = 0;
        while(true){
            System.out.println(ten +" : " +i);
            i++;
            if(i>1000000)
                break;
        }
    }

}
