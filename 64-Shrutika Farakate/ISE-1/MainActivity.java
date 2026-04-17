package com.example.registrationlistapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.*;
import android.util.Patterns;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etMobile, etPassword, etConfirmPassword;
    RadioGroup radioGroup;
    Spinner spCity;
    Button btnSubmit;

    public static ArrayList<String> userList = new ArrayList<>();

    String[] cities = {"Select City", "Pune", "Mumbai", "Delhi", "Bangalore"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        radioGroup = findViewById(R.id.radioGroup);
        spCity = findViewById(R.id.spCity);
        btnSubmit = findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, cities);
        spCity.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {
            if (validateAll()) {

                String userData =
                        "Name: " + etName.getText().toString() +
                                "\nMobile: " + etMobile.getText().toString();

                userList.add(userData);

                startActivity(new Intent(MainActivity.this, ListActivity.class));
                clearFields();
            }
        });
    }

    private boolean validateAll() {

        if(etName.getText().length() < 3){
            etName.setError("Enter valid name");
            return false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText()).matches()){
            etEmail.setError("Invalid email");
            return false;
        }

        if(etMobile.getText().length() != 10){
            etMobile.setError("Enter 10 digit mobile");
            return false;
        }

        if(etPassword.getText().length() < 6){
            etPassword.setError("Min 6 characters");
            return false;
        }

        if(!etConfirmPassword.getText().toString()
                .equals(etPassword.getText().toString())){
            etConfirmPassword.setError("Password not match");
            return false;
        }

        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Select Gender",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(spCity.getSelectedItemPosition() == 0){
            Toast.makeText(this,"Select City",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void clearFields(){
        etName.setText("");
        etEmail.setText("");
        etMobile.setText("");
        etPassword.setText("");
        etConfirmPassword.setText("");
        radioGroup.clearCheck();
        spCity.setSelection(0);
    }
}