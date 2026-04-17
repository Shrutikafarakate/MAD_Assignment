package com.example.togglebutton;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Switch switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = findViewById(R.id.switchButton);

        switchButton.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                switchButton.setText("ON");
                Toast.makeText(MainActivity.this,
                        "Switch is ON",
                        Toast.LENGTH_SHORT).show();
            } else {
                switchButton.setText("OFF");
                Toast.makeText(MainActivity.this,
                        "Switch is OFF",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}