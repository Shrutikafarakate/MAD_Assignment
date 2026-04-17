package com.example.activityandfragmentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnFragment1);
        btn2 = findViewById(R.id.btnFragment2);


        loadFragment(new FragmentOne());

        btn1.setOnClickListener(v -> loadFragment(new FragmentOne()));
        btn2.setOnClickListener(v -> loadFragment(new FragmentTwo()));
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }


    public static class FragmentOne extends Fragment {
        @Override
        public View onCreateView(android.view.LayoutInflater inflater,
                                 android.view.ViewGroup container,
                                 Bundle savedInstanceState) {

            TextView tv = new TextView(getActivity());
            tv.setText("This is Fragment One");
            tv.setTextSize(20);
            tv.setPadding(50, 50, 50, 50);
            return tv;
        }
    }


    public static class FragmentTwo extends Fragment {
        @Override
        public View onCreateView(android.view.LayoutInflater inflater,
                                 android.view.ViewGroup container,
                                 Bundle savedInstanceState) {

            TextView tv = new TextView(getActivity());
            tv.setText("This is Fragment Two");
            tv.setTextSize(20);
            tv.setPadding(50, 50, 50, 50);
            return tv;
        }
    }
}
