package com.example.explicit_intent;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        backBtn = findViewById(R.id.btnBack);

        if(backBtn != null) {
            backBtn.setOnClickListener(v -> finish());
        }
    }
}