package com.example.poccamerausage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Context context = null;

    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        public static Camera getCameraInstance(){
            Camera c = null;
            try {
                c = Camera.; // attempt to get a Camera instance
            }
            catch (Exception e){
                // Camera is not available (in use or does not exist)
            }
            return c; // returns null if camera is unavailable
        }



    }
}
