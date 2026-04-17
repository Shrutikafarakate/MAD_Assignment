package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox java, python, android;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        java = findViewById(R.id.checkJava);
        python = findViewById(R.id.checkPython);
        android = findViewById(R.id.checkAndroid);
        btn = findViewById(R.id.btnShow);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = "Selected: ";

                if (java.isChecked())
                    result += "Java ";

                if (python.isChecked())
                    result += "Python ";

                if (android.isChecked())
                    result += "Android ";

                if (result.equals("Selected: "))
                    result = "No option selected";

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}