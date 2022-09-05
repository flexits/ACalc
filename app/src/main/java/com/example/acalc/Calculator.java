package com.example.acalc;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

/*
The Calculator class uses two buffers, leftOperand and rightOperand, to store numbers and
performs expressions evaluations accordingly to the buttons pressed.

While a number is being input, it's stored in the rightOperand buffer. Digits of the
number are input successively by pressing the corresponding buttons. On each subsequent button
press, the buffer content is multiplied by 10, then the corresponding digit is added.

If a decimal separator (.) button was pressed, the program switches into the fractional
part input mode (fractDivider counter is assigned 1). In this mode, each subsequent digit
is divided by 10^fractDivider and the result is added to the rightOperand buffer, while
fractDivider is incremented by 1.

After an action has been selected (+,-,*,/ button was pressed), the rightOperand buffer
content is copied to the leftOperand, the flag flushROpNeeded is set to true, and the selected
action is memorized in selectedAction variable. On a subsequent numeric button press,
the rightOperand will be cleared (set to 0) as well as the flag.
Such approach enables short operations, like [3][+][=] (equivalent to [3][+][3][=]) etc.

After the [=] button was pressed, the two operands are processed accordingly to the selected
action, and the resulting value is stored in the leftOperand buffer. At the same time,
flushActNeeded flag is set, but the rightOperand and the selectedAction variables still store
their values to make repeated [=] action possible: [3][+][=][=] works as [3][+][3][+][3][=].

If an action has been selected, but the [=] button was not pressed, the corresponding
expression will be evaluated on a subsequent action button press, and the result will be stored
in the leftOperand. Thus, the previous action will not be lost and [3][+][3][+][3][=] will
actually be 9.

Functions are executed immediately and the value of the rightOperand will be replaceb
by the calculation result.
*/

public class Calculator {
    private BigDecimal leftOperand = BigDecimal.valueOf(0);
    //here goes the number after its input is finished, or expression evaluation result
    private BigDecimal rightOperand = BigDecimal.valueOf(0);
    //here goes the number being input
    private boolean flushROpNeeded = false;
    //if true, the right operand input is finished, and it must be cleared on the next digit input
    private boolean flushActNeeded = false;
    //the flag is set true after an expression evaluation; the left operand contains result
    private int fractDivider = 0;
    //if 0, the integer part of a number is being input;
    //otherwise it indicates the place of the digit after the decimal separator
    private CalcActions selectedAction = CalcActions.NONE;
    //stores the history of calculations
    private String history = "\0";

    //Division by zero workaround
    private boolean isZeroDivDetected = false;
    private boolean checkZeroDiv(){
        isZeroDivDetected = ((selectedAction == CalcActions.DIVIDE) && rightOperand.equals(BigDecimal.valueOf(0)));
        return isZeroDivDetected;
    }

    //when rightOperand input was finished, set the flag and clear the fractional mode
    //Called on action, function and evaluate buttons press.
    private void rightOperandInputFinished(){
        flushROpNeeded = true;
        fractDivider = 0;
    }

    public void clearBuffers(){
        leftOperand = BigDecimal.valueOf(0);
        rightOperand = BigDecimal.valueOf(0);
        fractDivider = 0;
        flushActNeeded = false;
        flushROpNeeded = false;
        selectedAction = CalcActions.NONE;
        history = "\0";
    }

    public void pushDigit(int digit){
        if (flushROpNeeded) {
            flushROpNeeded = false;
            //clear the contents before adding a digit
            rightOperand = BigDecimal.valueOf(0);
        }
        //add a digit to the right operand
        if (fractDivider == 0){
            //the integer part of the operand is being input
            rightOperand = rightOperand.multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(digit));
        } else{
            //the fractional part of the operand is being input
            BigDecimal fractionPart = BigDecimal.valueOf(digit).divide(BigDecimal.valueOf(Math.pow(10, fractDivider)));
            rightOperand = rightOperand.add(fractionPart);
            fractDivider++;
        }
    }

    public void selectAction(@NonNull CalcActions action){
        if (action == CalcActions.NONE) return;
        fractDivider = 0;
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
                history = getLOperand();
            }
            else {
                //if an action was already selected, evaluate the existing expression first
                if (checkZeroDiv()){
                    clearBuffers();
                    return;
                }else{
                    leftOperand = selectedAction.evaluate(leftOperand, rightOperand);
                    history += selectedAction.getString(rightOperand);
                }
            }
        }
        rightOperandInputFinished();
        //finally remember the selected action
        selectedAction = action;
    }

    public void executeFunc(@NonNull CalcFunctions func){
        rightOperand = func.evaluate(rightOperand);
        rightOperandInputFinished();
    }

    public void insertDecimalSepr(){
        if (fractDivider > 0) return;
        fractDivider = 1;
    }

    public void evaluate(){
        if (checkZeroDiv()){
            clearBuffers();
            return;
        }else{
            leftOperand = selectedAction.evaluate(leftOperand, rightOperand);
            history += selectedAction.getString(rightOperand);
        }
        flushActNeeded = true;
        rightOperandInputFinished();
    }

    public String getLOperand(){
        return leftOperand.stripTrailingZeros().toPlainString();
    }

    public String getROperand(){
        return rightOperand.stripTrailingZeros().toPlainString();
    }

    public String getHistory(){
        return history;
    }

    public boolean checkAndResetZeroDivFlag(){
        boolean flag = isZeroDivDetected;
        isZeroDivDetected = false;
        return flag;
    }
}
