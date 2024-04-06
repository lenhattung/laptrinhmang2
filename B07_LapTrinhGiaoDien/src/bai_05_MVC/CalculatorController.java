package bai_05_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorView cv, CalculatorModel cm){
        this.view = cv;
        this.model = cm;
        view.addCalculateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1Value = view.getNum1Value();
                    double num2Value = view.getNum2Value();
                    String action = e.getActionCommand();
                    double result = model.calculate(num1Value, num2Value, action);
                    view.setResult(result);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }

}
