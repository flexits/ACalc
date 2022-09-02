package com.example.acalc;

import java.math.BigDecimal;

public enum CalcFunctions {
    SINE {public BigDecimal evaluate(BigDecimal operand){ return BigDecimal.valueOf(Math.sin(operand.doubleValue()));}};
    public abstract BigDecimal evaluate(BigDecimal operand);
}
