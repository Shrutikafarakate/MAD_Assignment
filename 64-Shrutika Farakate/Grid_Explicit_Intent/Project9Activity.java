package com.example.grid_explicit_intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Project9Activity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project9);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnLogout = findViewById(R.id.btnLogout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;

                Toast.makeText(Project9Activity.this,
                        b.getText() + " Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        };

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btnLogout.setOnClickListener(listener);
    }
}