package com.sabrigulseven.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1Text;
    EditText number2Text;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Text = findViewById(R.id.number1Text);
        number2Text = findViewById(R.id.number2Text);
        resultText = findViewById(R.id.result);
    }

    public void sum(View view){
        if(number1Text.getText().toString().matches("")
                || number2Text.getText().toString().matches("") ){
            resultText.setText("Enter Number");
        }else {
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1 + number2;
            resultText.setText("Result: " + result);
        }
    }
    public void deduct(View view){
        try {
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1 - number2;
            resultText.setText("Result: " + result);
        }catch (Exception e){
            resultText.setText("Enter Number");
        }

    }
    public void multiply(View view){
        try {
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1 * number2;
            resultText.setText("Result: " + result);
        }catch (Exception e){
            resultText.setText("Enter Number");
        }
    }

    public void divide(View view){
        try {
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            try {
                int result = number1 / number2;
                resultText.setText("Result: " + result);
            }catch (Exception e) {
                resultText.setText("Can't Divide With Zero");
            }

        }catch (Exception e){
            resultText.setText("Enter Number");
        }
    }
}