package bai_05_MVC;

import javax.swing.*;

public class RunProgram {
    public static void main(String[] args) {

        // Quy định về cách nhìn và cảm nhận
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }

        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
        view.setVisible(true);
    }
}
