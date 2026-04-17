package com.example.textfield;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextName);
        button = findViewById(R.id.btnSubmit);
        result = findViewById(R.id.txtResult);

        button.setOnClickListener(v -> {
            String name = editText.getText().toString();
            result.setText("Hello " + name);
        });
    }
}