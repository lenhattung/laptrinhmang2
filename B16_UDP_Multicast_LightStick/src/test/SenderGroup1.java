package test;

import main.LightControllerSender;

public class SenderGroup1 {
    public static void main(String[] args) {
        new LightControllerSender("230.0.0.1", 6789);
    }
}
