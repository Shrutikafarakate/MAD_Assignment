package com.example.framelayout;


import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnTop, btnCenter, btnBottom, btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTop = findViewById(R.id.btnTop);
        btnCenter = findViewById(R.id.btnCenter);
        btnBottom = findViewById(R.id.btnBottom);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);

        btnTop.setOnClickListener(v ->
                Toast.makeText(this, "Top Button Clicked", Toast.LENGTH_SHORT).show());

        btnCenter.setOnClickListener(v ->
                Toast.makeText(this, "Center Button Clicked", Toast.LENGTH_SHORT).show());

        btnBottom.setOnClickListener(v ->
                Toast.makeText(this, "Bottom Button Clicked", Toast.LENGTH_SHORT).show());

        btnLeft.setOnClickListener(v ->
                Toast.makeText(this, "Left Button Clicked", Toast.LENGTH_SHORT).show());

        btnRight.setOnClickListener(v ->
                Toast.makeText(this, "Right Button Clicked", Toast.LENGTH_SHORT).show());
    }
}