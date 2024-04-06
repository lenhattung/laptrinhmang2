package bai_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XinChao_XuLySuKien extends JFrame {
    public XinChao_XuLySuKien(){
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

    private void init(){
        JPanel mainPanel = new JPanel();
        // Quy định về bố cục
        mainPanel.setLayout(new BorderLayout());
        // Thêm một số nút nhấn
        JButton j_tren = new JButton("Phía trên");
        // Thêm xử lý sự kiện khi nhấn nút
        j_tren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị thông báo
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút phía trên");
            }
        });


        JButton j_duoi = new JButton("Phía dưới");
        j_duoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy ra được tên nguồn của sự kiện
                String text = e.getActionCommand();
                // Hiển thị thông báo
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });


        JButton j_trai = new JButton("Phía trái");
        j_trai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy ra được tên nguồn của sự kiện
                String text = e.getActionCommand();
                // Hiển thị thông báo
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });


        JButton j_phai = new JButton("Phía phải");
        j_phai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy ra được tên nguồn của sự kiện
                String text = e.getActionCommand();
                // Hiển thị thông báo
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        JButton j_trung_tam = new JButton("Trung tâm");
        j_trung_tam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy ra được tên nguồn của sự kiện
                String text = e.getActionCommand();
                // Hiển thị thông báo
                JOptionPane.showMessageDialog(null, "Bạn vừa nhấn nút: " + text);
            }
        });

        mainPanel.add(j_tren, BorderLayout.NORTH);
        mainPanel.add(j_duoi, BorderLayout.SOUTH);
        mainPanel.add(j_trai, BorderLayout.WEST);
        mainPanel.add(j_phai, BorderLayout.EAST);
        mainPanel.add(j_trung_tam, BorderLayout.CENTER);

        // Thêm JPanel vào chương trình
        this.add(mainPanel);
    }
    public static void main(String[] args) {
        // Quy định về cách nhìn và cảm nhận
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        new XinChao_XuLySuKien();
    }
}
