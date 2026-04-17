package com.example.verticallinearlayout;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button btnRegister, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnClear = findViewById(R.id.btnClear);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(MainActivity.this,
                        "All fields are required",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
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
