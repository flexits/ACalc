package com.example.acalc;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class Calculator {
    private BigDecimal leftOperand = BigDecimal.valueOf(0);
    //here goes the number after its input is finished, or expression evaluation result
    private BigDecimal rightOperand = BigDecimal.valueOf(0);
    //here goes the number being input
    private boolean flushROpNeeded = false;
    //if true, the right operand input is finished, and it must be cleared on the next digit input
    private boolean flushActNeeded = false;
    //the flag is set true after an expression evaluation; the left operand contains result

    private CalcActions selectedAction = CalcActions.NONE;

    public void resetBuffers(){
        leftOperand = BigDecimal.valueOf(0);
        rightOperand = BigDecimal.valueOf(0);
        flushActNeeded = false;
        flushROpNeeded = false;
        selectedAction = CalcActions.NONE;
    }

    public void pushDigit(int digit){
        //add a digit to the right operand
        if (flushROpNeeded) {
            rightOperand = BigDecimal.valueOf(digit);
            flushROpNeeded = false;
        }
        else {
            //rightOperand = (rightOperand * 10) + digit;
            rightOperand = rightOperand.multiply(BigDecimal.valueOf(10));
            rightOperand = rightOperand.add(BigDecimal.valueOf(digit));
        }
    }

    public void selectAction(@NonNull CalcActions action){
        if (action == CalcActions.NONE) return;

        if (flushActNeeded){
            //if there is already a result of a previous expression evaluation
            //in the left operand, skip all operand exchanges and just memorize the action
            flushActNeeded = false;
        } else{
            //copy the right operand into the left operand and
            //set the flag to clear the right operand upon a next digit push
            if (selectedAction == CalcActions.NONE){
                //if no action was previously selected, just copy the buffer
                leftOperand = rightOperand;
            }
            else {
                //if an action was already selected, evaluate the existing expression first
                leftOperand = selectedAction.evaluate(leftOperand, rightOperand);
            }
        }
        flushROpNeeded = true;
        //finally remember the selected action
        selectedAction = action;
    }

    public void executeFunc(@NonNull CalcFunctions func){
        rightOperand = func.evaluate(rightOperand);
    }

    public void insertDecimalSepr(){
        return;
    }

    public void evaluate(){
        leftOperand = selectedAction.evaluate(leftOperand, rightOperand);
        flushActNeeded = true;
    }

    public String getLOperand(){
        //return String.valueOf(leftOperand);
        return leftOperand.stripTrailingZeros().toPlainString();
    }

    public String getROperand(){
        //return Double.toString(rightOperand);
        //return String.valueOf(rightOperand);
        return rightOperand.stripTrailingZeros().toPlainString();
    }
}
