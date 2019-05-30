package com.example.poccamerausage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create intent
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        Log.i(TAG, "Creating intent");

        Button btnGoToCaptureImage = (Button)findViewById(R.id.btnGoToCaptureImage);
        btnGoToCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CaptureImage.class);

                startActivity(intent);
                Log.i(TAG, "Intent sent");
            }
        });
    }
}
