package main;

import javax.swing.*;
import java.awt.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class LightControllerGUI extends JFrame {
    private JLabel lightLabel;
    private JPanel mainPanel;

    private String ip;
    private int port;

    public LightControllerGUI(String ip, int port) {
        this.ip = ip;
        this.port = port;


        this.setTitle("Light");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        lightLabel = new JLabel("Light Status: ");
        lightLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(lightLabel, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(200, 100));
        this.getContentPane().add(mainPanel);
        this.pack();
        this.setVisible(true);

        startListening();
    }

    private void startListening() {
        try {
            InetAddress group = InetAddress.getByName(this.ip);
            MulticastSocket socket = new MulticastSocket(this.port);
            socket.joinGroup(group);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(receivedMessage);
                updateLightStatus(receivedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateLightStatus(String color) {
        if (color.equals("Red")) {
            mainPanel.setBackground(Color.RED);
            System.out.println("Red");
        } else if (color.equals("Green")) {
            mainPanel.setBackground(Color.GREEN);
            System.out.println("Green");
        } else if (color.equals("Blue")) {
            mainPanel.setBackground(Color.BLUE);
            System.out.println("Blue");
        }
        lightLabel.setText("Light Status: " + color);
        mainPanel.revalidate(); // Cập nhật lại giao diện panel
    }
}
