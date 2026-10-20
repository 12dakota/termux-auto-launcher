package com.termux.autolauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchTermux();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        launchTermux();
        finish();
    }

    private void launchTermux() {
        Intent intent = new Intent();
        intent.setClassName("com.termux", "com.termux.app.TermuxActivity");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (Exception e) {
            // Termux not installed or activity changed
        }
    }
}
