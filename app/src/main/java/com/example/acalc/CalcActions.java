package com.example.acalc;

public enum CalcActions {
    NONE {public double evaluate(double op1, double op2){ return op2;}},
    ADD {public double evaluate(double op1, double op2){ return op1 + op2;}},
    SUBTRACT {public double evaluate(double op1, double op2){ return op1 - op2;}},
    MULTIPLY {public double evaluate(double op1, double op2){ return op1 * op2;}},
    DIVIDE {public double evaluate(double op1, double op2){ return op1 / op2;}};
    public abstract double evaluate(double op1, double op2);
}
