package com.example.grid_explicit_intent;



import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Project6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project6);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);

        btn1.setOnClickListener(v ->
                Toast.makeText(Project6Activity.this, "Click Me Pressed", Toast.LENGTH_SHORT).show());

        btn2.setOnClickListener(v ->
                Toast.makeText(Project6Activity.this, "One Pressed", Toast.LENGTH_SHORT).show());

        btn3.setOnClickListener(v ->
                Toast.makeText(Project6Activity.this, "Two Pressed", Toast.LENGTH_SHORT).show());

        btn4.setOnClickListener(v ->
                Toast.makeText(Project6Activity.this, "Three Pressed", Toast.LENGTH_SHORT).show());

        btn5.setOnClickListener(v ->
                Toast.makeText(Project6Activity.this, "Four Pressed", Toast.LENGTH_SHORT).show());

        btn6.setOnClickListener(v ->
                Toast.makeText(Project6Activity.this, "Five Pressed", Toast.LENGTH_SHORT).show());
    }
}