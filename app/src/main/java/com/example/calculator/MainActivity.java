package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Boolean isOperationClick;
    private Double first, second;
    private String operation = "";

    private static Map<Object, KeyPressedStrategy> btnKey = new HashMap<>();

    public MainActivity() {
        btnKey.put(R.id.btn_1, new KeyPressedStrategy("1"));
        btnKey.put(R.id.btn_2, new KeyPressedStrategy("2"));
        btnKey.put(R.id.btn_3, new KeyPressedStrategy("3"));
        btnKey.put(R.id.btn_4, new KeyPressedStrategy("4"));
        btnKey.put(R.id.btn_5, new KeyPressedStrategy("5"));
        btnKey.put(R.id.btn_6, new KeyPressedStrategy("6"));
        btnKey.put(R.id.btn_7, new KeyPressedStrategy("7"));
        btnKey.put(R.id.btn_8, new KeyPressedStrategy("8"));
        btnKey.put(R.id.btn_9, new KeyPressedStrategy("9"));
        btnKey.put(R.id.btn_zero, new KeyPressedStrategy("0"));
        btnKey.put(R.id.btn_dot, new KeyPressedStrategy(() -> {
            if (!textView.getText().toString().endsWith(".")) return ".";
            return "";
        }));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_result);
    }

    public void onNumberClick(View view) {
        setNumber(view.getId());
    }

    public void onOperationClick(View view) {
        int id = view.getId();
        Double result = 0.0;

        if (id == R.id.btn_ac) {
            textView.setText("0");
            first = 0.0;
            second = 0.0;
        }

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
        } else if (id == R.id.btn_switch_sign) {
            first = Double.parseDouble(textView.getText().toString());
            result = (-1) * first;
            if (result % 1 == 0) {
                textView.setText(String.valueOf(result.intValue()));
            } else {
                textView.setText(result.toString());
            }
            isOperationClick = true;
        } else if (id == R.id.btn_percent) {
            second = Double.parseDouble(textView.getText().toString());
            double percent = first * second / 100;
            switch (operation) {
                case "+":
                    result = first + percent;
                    break;
                case "-":
                    result = first - percent;
                    break;
                case "×":
                    result = percent;
                    break;
                case "÷":
                    result = first / percent;
                    break;
            }
            if (result % 1 == 0) {
                textView.setText(String.valueOf(result.intValue()));
            } else {
                textView.setText(result.toString());
            }
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
            if (result % 1 == 0) {
                textView.setText(String.valueOf(result.intValue()));
            } else {
                textView.setText(result.toString());
            }
            isOperationClick = true;
        }
    }

    private void setNumber(Object key) {
        KeyPressedStrategy number = btnKey.get(key);
        String currentValue = textView.getText().toString();

        if (currentValue.equals("0") || isOperationClick) {
            textView.setText(number.getValue());
        } else {
            textView.append(number.getValue());
        }
        isOperationClick = false;
    }

}

