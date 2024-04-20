package server;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {

            Runtime.getRuntime().exec("shutdown -a");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
