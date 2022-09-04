package com.example.acalc;

import java.math.BigDecimal;

/*
Operations that require only one operand are described here.
An operation is selected by pressing the correspondent button, and is evaluated immediately.
*/

public enum CalcFunctions {
    SINE {public BigDecimal evaluate(BigDecimal operand){ return BigDecimal.valueOf(Math.sin(operand.doubleValue()));}};
    public abstract BigDecimal evaluate(BigDecimal operand);
}
