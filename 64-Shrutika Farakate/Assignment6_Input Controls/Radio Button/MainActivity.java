package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this,
                            "Please select an option",
                            Toast.LENGTH_SHORT).show();
                } else {
                    selectedRadioButton = findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();

                    Toast.makeText(MainActivity.this,
                            "Selected: " + selectedText,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}