package com.example.acalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvNum;
    private TextView tvHst;
    private Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNum = findViewById(R.id.tvNumbr);
        tvHst = findViewById(R.id.tvHistory);
        calc = new Calculator();
        updateDisplay(calc.getROperand());
    }

    private void updateDisplay(String number) {
        tvNum.setText(number);
        tvHst.setText(calc.getHistory());
    }

    public void btn1Press(View view){
        calc.pushDigit(1);
        updateDisplay(calc.getROperand());
    }

    public void btn2Press(View view){
        calc.pushDigit(2);
        updateDisplay(calc.getROperand());
    }

    public void btn3Press(View view){
        calc.pushDigit(3);
        updateDisplay(calc.getROperand());
    }

    public void btn4Press(View view){
        calc.pushDigit(4);
        updateDisplay(calc.getROperand());
    }

    public void btn5Press(View view){
        calc.pushDigit(5);
        updateDisplay(calc.getROperand());
    }

    public void btn6Press(View view){
        calc.pushDigit(6);
        updateDisplay(calc.getROperand());
    }

    public void btn7Press(View view){
        calc.pushDigit(7);
        updateDisplay(calc.getROperand());
    }

    public void btn8Press(View view){
        calc.pushDigit(8);
        updateDisplay(calc.getROperand());
    }

    public void btn9Press(View view){
        calc.pushDigit(9);
        updateDisplay(calc.getROperand());
    }

    public void btn0Press(View view){
        calc.pushDigit(0);
        updateDisplay(calc.getROperand());
    }

    public void btnSprPress(View view){
        calc.insertDecimalSepr();
        updateDisplay(calc.getROperand());
    }

    public void btnCPress(View view){
        calc.resetBuffers();
        updateDisplay(calc.getROperand());
    }

    public void btnAddPress(View view){
        calc.selectAction(CalcActions.ADD);
        updateDisplay(calc.getLOperand());
    }

    public void btnSubPress(View view){
        calc.selectAction(CalcActions.SUBTRACT);
        updateDisplay(calc.getLOperand());
    }

    public void btnMltPress(View view){
        calc.selectAction(CalcActions.MULTIPLY);
        updateDisplay(calc.getLOperand());
    }

    public void btnDivPress(View view){
        calc.selectAction(CalcActions.DIVIDE);
        updateDisplay(calc.getLOperand());
    }

    public void btnEvalPress(View view){
        calc.evaluate();
        updateDisplay(calc.getLOperand());
    }

    public void btnSinPress(View view){
        calc.executeFunc(CalcFunctions.SINE);
        updateDisplay(calc.getROperand());
    }
}