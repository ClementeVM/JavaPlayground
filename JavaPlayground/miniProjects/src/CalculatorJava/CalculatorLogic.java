package CalculatorJava;

public class CalculatorLogic {
    private double total;

    public CalculatorLogic() {
        this.total = 0.0;
    }

    public void add(double value) {
        total += value;
    }

    public void subtract(double value) {
        total -= value;
    }

    public void multiply(double value) {
        total *= value;
    }

    public void divide(double value) {
        if (value == 0) {
            throw new ArithmeticException("Cannot divide 0");
        }
        total /= value;
    }

    public void reset() {
        total = 0.0;
    }

    public double getTotal() {
        return total;
    }
}
