package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Math_page extends AppCompatActivity implements View.OnClickListener {

    TextView firstNumber;
    TextView secondNumber;
    TextView result;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button pow;
    Button sqrt;
    Button sin;
    Button cos;
    Button clear;
    Button equals;

    Button firstWindows;

    String act;
    boolean fnum;
    String chose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_page2);
        act = "";
        fnum = true;
        chose = "";

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        pow = findViewById(R.id.pow);
        sqrt = findViewById(R.id.sqrt);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);

        firstWindows = findViewById(R.id.firstWindows);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        pow.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        firstWindows.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.pow:
            case R.id.sqrt:
            case R.id.sin:
            case R.id.divide:
                Button button1 = (Button) view;
                act = button1.getText().toString();
                fnum = !fnum;
                break;
            case R.id.equals:
                float num1;
                if(firstNumber.getText().toString() == "") num1 = 0;
                else num1 = Float.valueOf(firstNumber.getText().toString());
                float num2;
                if(secondNumber.getText().toString() == "") num2 = 0;
                else num2 = Float.valueOf(secondNumber.getText().toString());
                switch (act) {
                    case ("x^y"):
                        double resPow = Math.pow(num1, num2);
                        result.setText(String.valueOf(resPow));
                        break;
                    case ("√x"):
                        double resSqrt = Math.pow(num1, (1/num2));
                        result.setText(String.valueOf(resSqrt));
                        break;
                    case ("sin"):
                        double resSin = Math.sin(num1);
                        result.setText(String.valueOf(resSin));
                        break;
                    case ("cos"):
                        double resCos = Math.cos(num1);
                        result.setText(String.valueOf(resCos));
                        break;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                fnum = true;
                break;
            case R.id.firstWindows:
                Intent intent = new Intent(Math_page.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}