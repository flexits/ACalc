package com.example.acalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvNum;
    private Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNum = findViewById(R.id.tvNumbr);
        calc = new Calculator();
        tvNum.setText(calc.getROperand());
    }

    public void btn1Press(View view){
        calc.pushDigit(1);
        tvNum.setText(calc.getROperand());
    }

    public void btn2Press(View view){
        calc.pushDigit(2);
        tvNum.setText(calc.getROperand());
    }

    public void btn3Press(View view){
        calc.pushDigit(3);
        tvNum.setText(calc.getROperand());
    }

    public void btn4Press(View view){
        calc.pushDigit(4);
        tvNum.setText(calc.getROperand());
    }

    public void btn5Press(View view){
        calc.pushDigit(5);
        tvNum.setText(calc.getROperand());
    }

    public void btn6Press(View view){
        calc.pushDigit(6);
        tvNum.setText(calc.getROperand());
    }

    public void btn7Press(View view){
        calc.pushDigit(7);
        tvNum.setText(calc.getROperand());
    }

    public void btn8Press(View view){
        calc.pushDigit(8);
        tvNum.setText(calc.getROperand());
    }

    public void btn9Press(View view){
        calc.pushDigit(9);
        tvNum.setText(calc.getROperand());
    }

    public void btn0Press(View view){
        calc.pushDigit(0);
        tvNum.setText(calc.getROperand());
    }

    public void btnCPress(View view){
        calc.resetBuffers();
        tvNum.setText(calc.getROperand());
    }

    public void btnAddPress(View view){
        calc.selectAction(CalcActions.ADD);
        tvNum.setText(calc.getLOperand());
    }

    public void btnSubPress(View view){
        calc.selectAction(CalcActions.SUBTRACT);
        tvNum.setText(calc.getLOperand());
    }

    public void btnMltPress(View view){
        calc.selectAction(CalcActions.MULTIPLY);
        tvNum.setText(calc.getLOperand());
    }

    public void btnDivPress(View view){
        calc.selectAction(CalcActions.DIVIDE);
        tvNum.setText(calc.getLOperand());
    }

    public void btnEvalPress(View view){
        calc.evaluate();
        tvNum.setText(calc.getLOperand());
    }

    public void btnSinPress(View view){
        calc.executeFunc(CalcFunctions.SINE);
        tvNum.setText(calc.getROperand());
    }
}