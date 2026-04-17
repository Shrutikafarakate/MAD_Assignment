package com.example.grid_explicit_intent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Project1Activity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project1);

        mainLayout = findViewById(R.id.mainLayout);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        // Red
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.RED);
            }
        });

        // Green
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.GREEN);
            }
        });

        // Blue
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
