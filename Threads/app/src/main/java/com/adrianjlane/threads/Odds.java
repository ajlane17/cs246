package com.adrianjlane.threads;

import java.util.concurrent.TimeUnit;

public class Odds implements Runnable {

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
    }
}
