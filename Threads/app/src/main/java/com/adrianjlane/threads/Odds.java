package com.adrianjlane.threads;

import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Odds extends MainActivity implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(250);
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Making a toast
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Counting is complete", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
