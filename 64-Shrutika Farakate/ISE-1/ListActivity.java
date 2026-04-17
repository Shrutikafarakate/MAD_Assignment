package com.example.registrationlistapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        btnBack = findViewById(R.id.btnBack);

        UserAdapter adapter = new UserAdapter(this, MainActivity.userList);
        listView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());
    }

    class UserAdapter extends ArrayAdapter<String> {

        Context context;
        ArrayList<String> list;

        public UserAdapter(Context context, ArrayList<String> list) {
            super(context, 0, list);
            this.context = context;
            this.list = list;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context)
                        .inflate(R.layout.list_item, parent, false);
            }

            TextView tvName = convertView.findViewById(R.id.tvName);
            TextView tvMobile = convertView.findViewById(R.id.tvMobile);
            Button btnCall = convertView.findViewById(R.id.btnCall);

            String data = list.get(position);

            String[] parts = data.split("\n");

            String name = parts[0].replace("Name: ", "");
            String mobile = parts[1].replace("Mobile: ", "");

            tvName.setText(name);
            tvMobile.setText(mobile);

            btnCall.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + mobile));
                context.startActivity(intent);
            });

            return convertView;
        }
    }
}