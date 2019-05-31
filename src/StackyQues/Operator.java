package StackyQues;

public class Operator {
    private String symbol;
    private int precedence;

    public Operator(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPrecedence() {
        return precedence;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
