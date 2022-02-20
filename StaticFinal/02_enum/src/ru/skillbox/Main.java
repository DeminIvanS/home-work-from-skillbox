package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalc = new ArithmeticCalculator(Operation.ADD);
        arithmeticCalc.result(12, 15);

        ArithmeticCalculator arithmeticCalc1 = new ArithmeticCalculator(Operation.SUBTRACT);
        arithmeticCalc1.result(12, 15);

        ArithmeticCalculator arithmeticCalc2 = new ArithmeticCalculator(Operation.MULTIPLY);
        arithmeticCalc2.result(12, 15);

        arithmeticCalc.print();
        arithmeticCalc1.print();
        arithmeticCalc2.print();
    }
}
