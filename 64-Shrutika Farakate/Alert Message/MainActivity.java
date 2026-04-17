package com.example.alertmsg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Alert Message");
                builder.setMessage("Are you sure you want to exit?");

                builder.setPositiveButton("Yes", (dialog, which) -> {
                    finish();   // close app
                });

                builder.setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                });

                builder.setCancelable(false);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}