package com.example.acalc;

public enum CalcFunctions {
    SINE {public double evaluate(double operand){ return Math.sin(operand);}};
    public abstract double evaluate(double operand);
}
