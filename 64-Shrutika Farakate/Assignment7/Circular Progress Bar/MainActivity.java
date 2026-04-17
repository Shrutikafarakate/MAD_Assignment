package com.example.circularprogressbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSelect, btnUpload;
    ProgressBar progressBar;
    TextView txtPercent;
    FrameLayout progressLayout;

    Uri fileUri;
    int progress = 0;

    private static final int PICK_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelect = findViewById(R.id.btnSelect);
        btnUpload = findViewById(R.id.btnUpload);
        progressBar = findViewById(R.id.progressBar);
        txtPercent = findViewById(R.id.txtPercent);
        progressLayout = findViewById(R.id.progressLayout);

        btnSelect.setOnClickListener(v -> selectFile());
        btnUpload.setOnClickListener(v -> startUpload());
    }

    private void selectFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE && resultCode == RESULT_OK && data != null) {
            fileUri = data.getData();
            Toast.makeText(this, "File Selected", Toast.LENGTH_SHORT).show();
            btnUpload.setEnabled(true);
        }
    }

    private void startUpload() {
        if (fileUri == null) {
            Toast.makeText(this, "Select file first", Toast.LENGTH_SHORT).show();
            return;
        }

        btnSelect.setVisibility(View.GONE);
        btnUpload.setVisibility(View.GONE);
        progressLayout.setVisibility(View.VISIBLE);

        progress = 0;
        Handler handler = new Handler();

        new Thread(() -> {
            while (progress <= 100) {
                handler.post(() -> {
                    progressBar.setProgress(progress);
                    txtPercent.setText(progress + "%");
                });

                try {
                    Thread.sleep(100); // simulate upload
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                progress++;
            }

            handler.post(() -> {
                progressLayout.setVisibility(View.GONE);
                btnSelect.setVisibility(View.VISIBLE);
                btnUpload.setVisibility(View.VISIBLE);
                btnUpload.setEnabled(false);
                Toast.makeText(this, "Upload Complete", Toast.LENGTH_SHORT).show();
            });

        }).start();
    }
}