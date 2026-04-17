package com.example.progressbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;
import okhttp3.*;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_FILE = 1;

    Button btnSelect;
    ProgressBar progressBar;
    TextView txtProgress;

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelect = findViewById(R.id.btnSelect);
        progressBar = findViewById(R.id.progressBar);
        txtProgress = findViewById(R.id.txtProgress);

        btnSelect.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            startActivityForResult(intent, PICK_FILE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE && resultCode == Activity.RESULT_OK) {
            Uri fileUri = data.getData();
            uploadFile(fileUri);
        }
    }

    private void uploadFile(Uri uri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            byte[] fileBytes = new byte[inputStream.available()];
            inputStream.read(fileBytes);

            RequestBody requestBody = new ProgressRequestBody(fileBytes);

            Request request = new Request.Builder()
                    .url("https://httpbin.org/post") // test server
                    .post(requestBody)
                    .build();

            new Thread(() -> {
                try {
                    client.newCall(request).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Custom RequestBody for progress
    class ProgressRequestBody extends RequestBody {

        private byte[] file;

        ProgressRequestBody(byte[] file) {
            this.file = file;
        }

        @Override
        public MediaType contentType() {
            return MediaType.parse("application/octet-stream");
        }

        @Override
        public long contentLength() {
            return file.length;
        }

        @Override
        public void writeTo(okio.BufferedSink sink) throws java.io.IOException {

            long uploaded = 0;

            for (int i = 0; i < file.length; i++) {
                sink.writeByte(file[i]);
                uploaded++;

                int progress = (int) ((uploaded * 100) / file.length);

                runOnUiThread(() -> {
                    progressBar.setProgress(progress);
                    txtProgress.setText(progress + "%");
                });
            }
        }
    }
}