package com.example.horizontallinearlayout;



import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etId, etSalary;
    Button btnSubmit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etSalary = findViewById(R.id.etSalary);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String id = etId.getText().toString();
            String salary = etSalary.getText().toString();

            if(name.isEmpty() || id.isEmpty() || salary.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Employee Added:\nName: " + name +
                                "\nID: " + id +
                                "\nSalary: " + salary,
                        Toast.LENGTH_LONG).show();
            }
        });

        btnClear.setOnClickListener(v -> {
            etName.setText("");
            etId.setText("");
            etSalary.setText("");
        });
    }
}
