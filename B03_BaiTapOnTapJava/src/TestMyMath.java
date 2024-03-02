public class TestMyMath {
    public static void main(String[] args) {
        MyMath m1 = new MyMath();
        double s = m1.sum(5, 6);
        System.out.println(s);

        double s2 = MyMath2.sum(10, 20);
        System.out.println(s2);
    }
}
