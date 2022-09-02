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
        updateUI();
    }

    private void updateUI(){
        tvNum.setText(calc.getROperand());
    }

    public void btn1Press(View view){
        calc.pushDigit(1);
        updateUI();
    }

    public void btn2Press(View view){
        calc.pushDigit(2);
        updateUI();
    }

    public void btn3Press(View view){
        calc.pushDigit(3);
        updateUI();
    }

    public void btn4Press(View view){
        calc.pushDigit(4);
        updateUI();
    }

    public void btn5Press(View view){
        calc.pushDigit(5);
        updateUI();
    }

    public void btn6Press(View view){
        calc.pushDigit(6);
        updateUI();
    }

    public void btn7Press(View view){
        calc.pushDigit(7);
        updateUI();
    }

    public void btn8Press(View view){
        calc.pushDigit(8);
        updateUI();
    }

    public void btn9Press(View view){
        calc.pushDigit(9);
        updateUI();
    }

    public void btn0Press(View view){
        calc.pushDigit(0);
        updateUI();
    }

    public void btnCPress(View view){
        calc.resetBuffers();
        updateUI();
    }
}