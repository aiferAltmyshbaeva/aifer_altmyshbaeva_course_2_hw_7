package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Boolean isOperationClick;
    private Double first, second;
    private String operation = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_result);
    }
    public void onNumberClick(View view){
        int id = view.getId();
        if (id == R.id.btn_1) {
            setNumber("1");
        } else if (id == R.id.btn_2) {
            setNumber("2");
        } else if (id == R.id.btn_3) {
            setNumber("3");
        } else if (id == R.id.btn_4) {
            setNumber("4");
        } else if (id == R.id.btn_5) {
            setNumber("5");
        } else if (id == R.id.btn_6) {
            setNumber("6");
        } else if (id == R.id.btn_7) {
            setNumber("7");
        } else if (id == R.id.btn_8) {
            setNumber("8");
        } else if (id == R.id.btn_9) {
            setNumber("9");
        }
    }
    public void onOperationClick(View view){
        int id = view.getId();
        if (id == R.id.btn_ac){
            textView.setText("0");
            first = 0.0;
            second = 0.0;
        }
        Double result = 0.0;
        if (id == R.id.btn_plus) {
            operation = "+";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        } else if (id == R.id.btn_minus) {
            operation = "-";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        } else if (id == R.id.btn_multiplication) {
            operation = "×";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        } else if (id == R.id.btn_division) {
            operation = "÷";
            first = Double.parseDouble(textView.getText().toString());
            isOperationClick = true;
        } else if (id == R.id.btn_erase) {
            first = Double.parseDouble(textView.getText().toString());
            result = (-1) * first;
            textView.setText(result.toString());
            isOperationClick = true;
        } else if (id == R.id.btn_equal) {
            second = Double.parseDouble(textView.getText().toString());
            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "×":
                    result = first * second;
                    break;
                case "÷":
                    result = first / second;
                    break;
            }
            textView.setText(result.toString());
            isOperationClick = true;
        }
    }
    private void setNumber(String number){
       if(textView.getText().toString().equals("0")){
           textView.setText(number);
       }else if (isOperationClick){
           textView.setText(number);
       }
       else {
           textView.append(number);
       }
       isOperationClick = false;
    }

}