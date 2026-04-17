package com.example.grid_explicit_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project1Activity.class)));
        btn2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project2Activity.class)));
        btn3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project3Activity.class)));
        btn4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project4Activity.class)));
        btn5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project5Activity.class)));
        btn6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project6Activity.class)));
        btn7.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project7Activity.class)));
        btn8.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project8Activity.class)));
        btn9.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Project9Activity.class)));
    }
}