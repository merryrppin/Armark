package com.wmgf.armarkapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "y8wmjElyLKrCxhI222PExzkjL";
    private static final String TWITTER_SECRET = "jzKrToVjYNEKcMWYWmmFMIWdHCVVZC04iau9ruVmauhh9pbnIO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        Intent act = new Intent(this, LoginActivity.class);
        startActivity(act);
    }

}
