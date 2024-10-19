package com.example.calculator_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button addButton, subButton, mulButton, divButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        addButton = findViewById(R.id.addButton);
        subButton = findViewById(R.id.subButton);
        mulButton = findViewById(R.id.mulButton);
        divButton = findViewById(R.id.divButton);
        result = findViewById(R.id.result);

        // Set listeners for the buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    // Method to perform the calculation
    private void calculate(char operator) {
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double number1 = Double.parseDouble(n1);
        double number2 = Double.parseDouble(n2);
        double res = 0;

        switch (operator) {
            case '+':
                res = number1 + number2;
                break;
            case '-':
                res = number1 - number2;
                break;
            case '*':
                res = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    res = number1 / number2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        result.setText("Result: " + res);
    }
}
