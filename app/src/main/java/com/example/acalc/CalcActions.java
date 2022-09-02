package com.example.acalc;

import java.math.BigDecimal;

public enum CalcActions {
    NONE {public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op2;}},
    ADD {public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.add(op2);}},
    SUBTRACT {public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.subtract(op2);}},
    MULTIPLY {public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.multiply(op2);}},
    DIVIDE {public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.divide(op2);}};
    public abstract BigDecimal evaluate(BigDecimal op1, BigDecimal op2);
}
