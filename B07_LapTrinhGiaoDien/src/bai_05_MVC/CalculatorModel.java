package bai_05_MVC;

public class CalculatorModel {
    double a, b;

    public CalculatorModel() {
    }

    public CalculatorModel(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double add() {
        return this.a + this.b;
    }

    public double subtract() {
        return this.a - this.b;
    }

    public double multiply() {
        return this.a * this.b;
    }

    public double divide() {
        return this.a / this.b;
    }
    public double power() {
        return  Math.pow(this.a, this.b);
    }

    public double calculate(double a, double b, String op) {
        this.setA(a);
        this.setB(b);
        if (op.equals("+")) {
            return this.add();
        } else if (op.equals("-")) {
            return this.subtract();
        } else if (op.equals("*")) {
            return this.multiply();
        } else if (op.equals("/")) {
            return this.divide();
        }else if (op.equals("^")) {
            return this.power();
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        CalculatorModel cm = new CalculatorModel(5, 2);
        System.out.println(cm.add());
    }
}
