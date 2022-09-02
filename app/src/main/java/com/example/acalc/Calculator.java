package com.example.acalc;

public class Calculator {
    //buffers
    private double leftOperand = 0;
    private double rightOperand = 0;
    private double result = 0;

    private CalcActions selectedAction = CalcActions.NONE;

    public void resetBuffers(){
        leftOperand = 0;
        rightOperand = 0;
        selectedAction = CalcActions.NONE;
        result = 0;
    }

    public void pushDigit(int digit){
        //add a digit to buffer
        rightOperand = (rightOperand * 10) + digit;
    }

    public void selectAction(CalcActions action){
        if (action == CalcActions.NONE) return;
        if (selectedAction == CalcActions.NONE){
            //if no action was previously selected, copy the buffer
            leftOperand = rightOperand;
        }
        else {
            //if an action was already selected, evaluate the existing expression first
            leftOperand = selectedAction.evaluate(leftOperand, rightOperand);
            //if wasEvaluated
        }
        //finally remember the selected action
        selectedAction = action;
    }

    public void insertDecimalSepr(){
        return;
    }

    public double evaluate(){
        if (selectedAction == CalcActions.NONE) return rightOperand;
        else return leftOperand = selectedAction.evaluate(leftOperand, rightOperand);
    }

    public String getROperand(){
        //return Double.toString(rightOperand);
        return String.valueOf(rightOperand);
    }
}
