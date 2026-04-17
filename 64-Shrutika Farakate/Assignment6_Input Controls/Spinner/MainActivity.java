package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btn;

    String[] cities = {"Select City", "Pune", "Mumbai", "Delhi", "Chennai", "Bangalore"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerCity);
        btn = findViewById(R.id.btnShow);

        // Create Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cities
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       
        spinner.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedItem = spinner.getSelectedItem().toString();

                if (selectedItem.equals("Select City")) {
                    Toast.makeText(MainActivity.this,
                            "Please select a city",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Selected: " + selectedItem,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}