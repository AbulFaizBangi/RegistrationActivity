package com.example.registrationactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity<MainActivity> extends AppCompatActivity {

    private RadioGroup radioGroupGender;
    private CheckBox checkBoxTerms;
    private Button buttonSubmit;
    private EditText editTextName;
    private Spinner spinnerCountry;

    private static final String[] COUNTRIES = {"USA", "INDIA", "GERMANY", "DUBAI"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeViews();
        setupSpinner();
        setupSubmitButton();
    }

    private void initializeViews() {
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        editTextName = findViewById(R.id.editTextName);
        spinnerCountry = findViewById(R.id.spinnerCountry);
    }

    private void setupSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, COUNTRIES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);
    }

    private void setupSubmitButton() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = editTextName.getText().toString();
        String gender = getSelectedGender();
        String country = spinnerCountry.getSelectedItem().toString();
        boolean termsAccepted = checkBoxTerms.isChecked();

        if (name.isEmpty()) {
            showToast("Please enter your name");
            return;
        }

        if (termsAccepted) {
            Intent intent = new Intent(RegistrationActivity.this, DisplayResultActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("GENDER", gender);
            intent.putExtra("COUNTRY", country);
            startActivity(intent);
        } else {
            showToast("Please accept the terms and conditions");
        }
    }

    private String getSelectedGender() {
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton radioButtonSelected = findViewById(selectedGenderId);
        return radioButtonSelected.getText().toString();
    }

    private void showToast(String message) {
        Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
