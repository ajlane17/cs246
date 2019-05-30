package com.adrianjlane.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start another thread that takes a class implementing runnable
        new Thread(new Evens()).start();
        new Thread(new Odds()).start();
    }
}
