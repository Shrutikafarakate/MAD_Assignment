package com.example.relativelayout;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnProfile, btnAttendance, btnMarks, btnSettings, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btnProfile);
        btnAttendance = findViewById(R.id.btnAttendance);
        btnMarks = findViewById(R.id.btnMarks);
        btnSettings = findViewById(R.id.btnSettings);
        btnLogout = findViewById(R.id.btnLogout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button) v;
                Toast.makeText(MainActivity.this,
                        clicked.getText() + " Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        };

        btnProfile.setOnClickListener(listener);
        btnAttendance.setOnClickListener(listener);
        btnMarks.setOnClickListener(listener);
        btnSettings.setOnClickListener(listener);
        btnLogout.setOnClickListener(listener);
    }
}