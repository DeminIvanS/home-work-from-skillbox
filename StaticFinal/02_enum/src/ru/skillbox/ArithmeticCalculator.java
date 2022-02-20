package ru.skillbox;

public class ArithmeticCalculator {
    public final Operation symbol;
    private int result;

    public ArithmeticCalculator(Operation symbol) {
        this.symbol = symbol;
    }
    public Operation getSymbol() {
        return symbol;
    }

    public void result (int x, int y) {
        if (symbol == Operation.ADD){
            result = x + y;
        }
        if(symbol == Operation.MULTIPLY){
            result = x * y;
        }
        if(symbol == Operation.SUBTRACT){
            result = x - y;
        }

    }
    public void print() {
        System.out.println("результат: " + result );
    }
}
