package bai_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class MyNSLookup extends JFrame {
    public MyNSLookup(){
        // Xây dựng một số nội dung trong chương trình
        this.init();
        // Gán tên trên thanh tiêu đề
        this.setTitle("Xin chào");
        // Quy định về kích thước
        this.setSize(600, 400);
        // Cửa sổ hiển thị ở giữa màn hình
        this.setLocationRelativeTo(null);
        // Quy định thoát chương trình khi đóng cửa sổ
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Cho phép hiện thị ra màn hình
        this.setVisible(true);
    }

    private void init() {
        JPanel mainPanel = new JPanel();
        // Quy định về bố cục
        mainPanel.setLayout(new FlowLayout());


        JPanel headerPanel = new JPanel();
        // Quy định về bố cục
        headerPanel.setLayout(new GridLayout(3,1));
        // Thêm nhãn
        JLabel tieude = new JLabel("PHẦN MỀM TRA CỨU ĐỊA CHỈ IP");
        tieude.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(tieude);

        // Thêm một số text input
        JTextField domainname_input = new JTextField();
        domainname_input.setColumns(50);
        headerPanel.add(domainname_input);



        // Thêm nút nhấn tra cứu
        JButton tracuu = new JButton("Tra Cứu");

        headerPanel.add(tracuu);

        // Thêm một JTextarea
        JTextArea jta_rs = new JTextArea();
        jta_rs.setColumns(50);
        jta_rs.setRows(20);
        jta_rs.setEditable(false);

        JPanel rsPanel = new JPanel();
        // Quy định về bố cục
        rsPanel.setLayout(new FlowLayout());
        rsPanel.add(jta_rs);

        // Thêm các thành phần vào main panel
        mainPanel.add(headerPanel);
        mainPanel.add(rsPanel);
        // Thêm main panel vào jframe
        this.add(mainPanel);


        tracuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // In thông tin
                try {
                    InetAddress ia = InetAddress.getByName(domainname_input.getText());
                    // in thông tin
                    String result = "";
                    result+=("IP: " +ia.getHostAddress()+"\n");
                    result+=("Domain: " +ia.getHostName()+"\n");
                    result+=("Reachable: " + ia.isReachable(120)+"\n");
                    result+=("MulticastAddress: " + ia.isMulticastAddress()+"\n");
                    result+=("SiteLocalAddress: " + ia.isMulticastAddress()+"\n");
                    jta_rs.setText(result);

                }catch (Exception e1){
                    //e.printStackTrace();
                    System.out.println("Gặp lỗi, vui lòng nhập địa chỉ khác!");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Quy định về cách nhìn và cảm nhận
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        new MyNSLookup();
    }
}
