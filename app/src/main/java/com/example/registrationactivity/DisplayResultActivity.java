package com.example.registrationactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayResultActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        textViewResult = findViewById(R.id.textViewResult);
        displayResult();
    }

    private void displayResult() {
        String name = getIntent().getStringExtra("NAME");
        String gender = getIntent().getStringExtra("GENDER");
        String country = getIntent().getStringExtra("COUNTRY");

        String result = "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Country: " + country;

        textViewResult.setText(result);
    }
}
