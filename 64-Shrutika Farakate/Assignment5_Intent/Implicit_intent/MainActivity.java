package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnCall, btnSms, btnEmail, btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);
        btnEmail = findViewById(R.id.btnEmail);
        btnMap = findViewById(R.id.btnMap);

        btnWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            open(intent);
        });

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
            open(intent);
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:9373820893"));
            intent.putExtra("sms_body", "Hello from my app!");
            open(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Test Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from app");
            open(intent);
        });

        btnMap.setOnClickListener(v -> {
            Uri uri = Uri.parse("geo:19.0760,72.8777?q=Mumbai");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            open(intent);
        });
    }

    private void open(Intent intent) {
        try {
            startActivity(Intent.createChooser(intent, "Choose App"));
        } catch (Exception e) {
            Toast.makeText(this, "No app available", Toast.LENGTH_SHORT).show();
        }
    }
}