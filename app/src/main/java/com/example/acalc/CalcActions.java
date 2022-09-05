package com.example.acalc;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
Operations that require two operands are described here.
An operation is selected by pressing the correspondent button,
and is evaluated by pressing [=] button.
*/

public enum CalcActions {
    NONE {
        public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op2; }
        public String getString(BigDecimal op2){ return ""; }
    },
    ADD {
        public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.add(op2); }
        public String getString(BigDecimal op2){
            return " + " + op2.stripTrailingZeros().toPlainString();
        }
    },
    SUBTRACT {
        public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.subtract(op2); }
        public String getString(BigDecimal op2){
            return " - " + op2.stripTrailingZeros().toPlainString();
        }
    },
    MULTIPLY {
        public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.multiply(op2); }
        public String getString(BigDecimal op2){
            return " * " + op2.stripTrailingZeros().toPlainString();
        }
    },
    DIVIDE {
        public BigDecimal evaluate(BigDecimal op1, BigDecimal op2){ return op1.divide(op2, 8, RoundingMode.HALF_UP); }
        public String getString(BigDecimal op2){
            return " / " + op2.stripTrailingZeros().toPlainString();
        }
    };
    public abstract BigDecimal evaluate(BigDecimal op1, BigDecimal op2);
    public abstract String getString(BigDecimal op2);
}
