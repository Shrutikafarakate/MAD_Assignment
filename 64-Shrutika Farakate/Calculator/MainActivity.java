package com.example.operations;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView resultText;
    Button addBtn, subBtn, mulBtn, divBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultText = findViewById(R.id.resultText);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        addBtn.setOnClickListener(v -> calculate("+"));
        subBtn.setOnClickListener(v -> calculate("-"));
        mulBtn.setOnClickListener(v -> calculate("*"));
        divBtn.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {

        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if(n1.isEmpty() || n2.isEmpty()){
            resultText.setText("Enter both numbers");
            return;
        }

        double number1 = Double.parseDouble(n1);
        double number2 = Double.parseDouble(n2);
        double result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if(number2 != 0)
                    result = number1 / number2;
                else {
                    resultText.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        resultText.setText(n1 + " " + operator + " " + n2 + " = " + result);
    }
}