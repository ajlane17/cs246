package com.adrianjlane.threads;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start another thread that takes a class implementing runnable
        new Thread(new Evens(this)).start();
        new Thread(new Odds(this)).start();

        //Create button and its listener
        Button btnEvens = (Button)findViewById(R.id.btnEvens);
        btnEvens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Evens(MainActivity.this)).start();
            }
        });

        Button btnOdds = (Button)findViewById(R.id.btnOdds);
        btnOdds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Odds(MainActivity.this)).start();
            }
        });


    }
}
