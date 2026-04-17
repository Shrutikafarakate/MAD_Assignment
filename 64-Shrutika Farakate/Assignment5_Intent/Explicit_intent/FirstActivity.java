package com.example.explicit_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    Button profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        profileBtn = findViewById(R.id.btnProfile);

        profileBtn.setOnClickListener(v -> {

            // 🔹 EXPLICIT INTENT → Login Page
            Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
            startActivity(intent);

        });
    }
}