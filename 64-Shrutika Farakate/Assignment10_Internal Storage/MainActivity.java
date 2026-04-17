package com.example.internalstorage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView tvResult;
    Button btnSave, btnRead;
    String fileName = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        tvResult = findViewById(R.id.tvResult);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);

        btnSave.setOnClickListener(v -> {
            String data = editText.getText().toString();

            if (data.isEmpty()) {
                Toast.makeText(this, "Enter data first", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();
                editText.setText("");
                Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error Saving", Toast.LENGTH_SHORT).show();
            }
        });

        btnRead.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(fileName);
                int size = fis.available();
                byte[] buffer = new byte[size];
                fis.read(buffer);
                fis.close();

                String text = new String(buffer);
                tvResult.setText(text);

                Toast.makeText(this, "Data Read", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}