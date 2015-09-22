package com.wmgf.armarkapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "6haboLvf3pa9zXeDjUU8jQg1v";
    private static final String TWITTER_SECRET = "JIGiFIh5ytdaV7dGXoQgCAv1WGtpEzGGWX50LHr5UfdavLashA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        Intent act = new Intent(this, MenuPrincipalActivity.class);
        startActivity(act);
    }

}
