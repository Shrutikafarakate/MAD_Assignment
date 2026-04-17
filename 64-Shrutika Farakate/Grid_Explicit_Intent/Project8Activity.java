package com.example.grid_explicit_intent;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Project8Activity extends AppCompatActivity {

    ListView listView;

    String[] languages = {
            "Java",
            "Python",
            "C",
            "C++",
            "Kotlin",
            "Flutter",
            "Go"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project8);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                languages
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(Project8Activity.this,
                    "You clicked: " + languages[position],
                    Toast.LENGTH_SHORT).show();
        });
    }
}