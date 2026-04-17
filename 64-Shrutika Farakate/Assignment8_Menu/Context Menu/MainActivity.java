package com.example.contextualmenutext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    float textSize = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Context Menu");

        textView = findViewById(R.id.textView);

        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Options");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.copy) {

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("text", textView.getText());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.increase) {

            textSize += 5;
            textView.setTextSize(textSize);

        } else if (id == R.id.decrease) {

            textSize -= 5;
            textView.setTextSize(textSize);

        } else if (id == R.id.bgcolor) {

            textView.setBackgroundColor(getResources().getColor(R.color.yellow));

        } else if (id == R.id.reset) {

            textView.setTextSize(20);
            textView.setBackgroundColor(getResources().getColor(R.color.lightGray));
        }

        return true;
    }
}