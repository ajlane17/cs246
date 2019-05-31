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
/*  TODO:   1. Detect and Access Camera - Create code to check for the existence of cameras and request access.
    TODO:   2. Create a Preview Class - Create a camera preview class that extends SurfaceView and implements
                the SurfaceHolder interface. This class previews the live images from the camera.
    TODO:   3. Build a Preview Layout - Once you have the camera preview class, create a view layout that
                incorporates the preview and the user interface controls you want.
    TODO:   4. Setup Listeners for Capture - Connect listeners for your interface controls to start image or video
                capture in response to user actions, such as pressing a button.
    TODO:   5. Capture and Save Files - Setup the code for capturing pictures or videos and saving the output.
    TODO:   6. Release the Camera - After using the camera, your application must properly release it for use
                by other applications.*/
