package com.example.zadachi;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Load CounterFragment only when there is no saved instance state
            loadCounterFragment();
        }}
    private void loadCounterFragment() {
            CounterFragment counterFragment = new CounterFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, counterFragment);
            transaction.commit();
        }
    }
