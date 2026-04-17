package com.example.grid_explicit_intent;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Project2Activity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button btnRegister, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project2);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnClear = findViewById(R.id.btnClear);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {

                Toast.makeText(Project2Activity.this,
                        "All fields are required",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(Project2Activity.this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(v -> {
            etName.setText("");
            etEmail.setText("");
            etPassword.setText("");
        });
    }
}