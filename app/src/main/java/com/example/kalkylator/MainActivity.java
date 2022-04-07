package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button clear;
    Button equals;
    Button secondWindows;

    String act;
    boolean fnum;

    Spinner spinner;
    String[] str_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        str_array = new String[10];
        str_array[0] = "История";
        for(int i=1; i< str_array.length; i++){
            str_array[i]=" ";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, str_array);
        spinner.setAdapter(adapter);

        act = "";
        fnum = true;

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
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        secondWindows = findViewById(R.id.secondWindows);

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
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        secondWindows.setOnClickListener(this);
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
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
                Button button1 = (Button) view;
                act = button1.getText().toString();
                fnum = !fnum;
                break;
            case R.id.equals:
                float num1 = Float.parseFloat(firstNumber.getText().toString());
                float num2 = Float.parseFloat(secondNumber.getText().toString());
                String[] str_array1 = new String[10];
                switch (act) {
                    case ("+"):
                        float resPlus = num1 + num2;
                        result.setText(String.valueOf(resPlus));
                        str_array1[0] = num1 + " + " + num2 + " = " + resPlus;
                        System.arraycopy(str_array, 0, str_array1, 1, 9);
                        System.arraycopy(str_array1, 0, str_array, 0, str_array.length);
                        break;
                    case ("-"):
                        float resMinus = num1 - num2;
                        result.setText(String.valueOf(resMinus));
                        str_array1[0] = num1 + " - " + num2 + " = " + resMinus;
                        System.arraycopy(str_array, 0, str_array1, 1, 9);
                        System.arraycopy(str_array1, 0, str_array, 0, str_array.length);
                        break;
                    case ("x"):
                        float resMultiply = num1 * num2;
                        result.setText(String.valueOf(resMultiply));
                        str_array1[0] = num1 + " * " + num2 + " = " + resMultiply;
                        System.arraycopy(str_array, 0, str_array1, 1, 9);
                        System.arraycopy(str_array1, 0, str_array, 0, str_array.length);
                        break;
                    case ("/"):
                        float resDivide = num1 / num2;
                        result.setText(String.valueOf(resDivide));
                        str_array1[0] = num1 + " / " + num2 + " = " + resDivide;
                        System.arraycopy(str_array, 0, str_array1, 1, 9);
                        System.arraycopy(str_array1, 0, str_array, 0, str_array.length);
                        break;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                fnum = true;
                break;
            case R.id.secondWindows:
                Intent intent = new Intent(MainActivity.this, Math_page.class);
                Bundle b = new Bundle();
                b.putStringArray("key", str_array);
                intent.putExtras(b);
                startActivity(intent);
                break;
        }
    }
}