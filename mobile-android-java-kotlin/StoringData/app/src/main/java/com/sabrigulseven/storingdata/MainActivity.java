package com.sabrigulseven.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textview);

        sharedPreferences = this.getSharedPreferences("com.sabrigulseven.storingdata", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("userAge", 0);
        textView.setText("Your age: " + storedAge);

    }

    public void save(View view) {
        if (!editText.getText().toString().matches("")) {
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your age: " + userAge);

            sharedPreferences
                    .edit()
                    .putInt("userAge", userAge)
                    .apply();
        }
    }

    public void delete(View view) {

        int storedData = sharedPreferences.getInt("userAge", 0);

        if (storedData != 0) {
            sharedPreferences.edit().remove("userAge").apply();
            textView.setText("Your age: ");

        }

    }
}