package bai_05_MVC;

import bai_04.MyNSLookup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField num1;
    private JTextField num2;
    private JLabel resultLabel;

    private JButton addButton, subtractButton, multiplyButton, divideButton, powerButton;


    public CalculatorView() {
        // Xây dựng một số nội dung trong chương trình
        this.init();
        // Gán tên trên thanh tiêu đề
        this.setTitle("Máy tính");
        // Quy định về kích thước
        this.setSize(200, 200);
        // Cửa sổ hiển thị ở giữa màn hình
        this.setLocationRelativeTo(null);
        // Quy định thoát chương trình khi đóng cửa sổ
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Cho phép hiện thị ra màn hình
        //  this.setVisible(true);
    }

    public void init() {
        JPanel inputPanel = new JPanel();
        num1 = new JTextField(10);
        num2 = new JTextField(10);
        JLabel num1Label = new JLabel("Số 1: ");
        JLabel num2Label = new JLabel("Số 2: ");
        inputPanel.add(num1Label);
        inputPanel.add(num1);
        inputPanel.add(num2Label);
        inputPanel.add(num2);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        powerButton = new JButton("^");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(powerButton);

        resultLabel = new JLabel("Result: ");
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(inputPanel);
        this.add(buttonPanel);
        this.add(resultLabel);
    }

    public double getNum1Value() {
        return Double.valueOf(this.num1.getText());
    }

    public double getNum2Value() {
        return Double.valueOf(this.num2.getText());
    }

    public void setResult(double value) {
        resultLabel.setText("Result: " + value);
    }

    public void addCalculateListener(ActionListener listener) {
        this.addButton.addActionListener(listener);
        this.subtractButton.addActionListener(listener);
        this.multiplyButton.addActionListener(listener);
        this.divideButton.addActionListener(listener);
        this.powerButton.addActionListener(listener);
    }
}
