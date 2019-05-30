package com.adrianjlane.threads;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class Evens implements Runnable  {

    WeakReference<Activity> weakActivity;

    public Evens(Activity activity) {
        this.weakActivity = new WeakReference<>(activity);
    }

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(250);
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        final Activity activity = weakActivity.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Making a toast
                    Context context = activity.getApplicationContext();
                    Toast toast = Toast.makeText(context, "Counting is complete", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }
}
