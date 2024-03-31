package bai_02;

import javax.swing.*;
import java.awt.*;

public class XinChao_LookAndFeel extends JFrame {
    public XinChao_LookAndFeel(){
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
        JButton j_duoi = new JButton("Phía dưới");
        JButton j_trai = new JButton("Phía trái");
        JButton j_phai = new JButton("Phía phải");
        JButton j_trung_tam = new JButton("Trung tâm");

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

        new XinChao_LookAndFeel();
    }
}
