package com.example.implicitintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.implicitintentexample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Start an activity matching an intent filter listening for CUSTOM_ACTION. In this
       app, this will match FirstActivity and SecondActivity (see the intent-filter section
       of AndroidManifest.xml). Since there is more than one matching intent-filter, the user will
       be presented with the app chooser dialog when this method is executed.
    */
    public void intentWithTwoMatchingFilters(View view) {
        Intent viewIntent = new Intent();
        viewIntent.setAction("com.example.IntentExample.CUSTOM_ACTION");

        if (viewIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(viewIntent);
        }
    }

    /* Start an activity matching an intent filter listening for CUSTOM_ACTION_OTHER. In this
       app, this will match ThirdActivity (see the intent-filter section
       of AndroidManifest.xml)
    */
    public void intentWithOneMatchingFilter(View view) {
        Intent viewIntent = new Intent();
        viewIntent.setAction("com.example.IntentExample.CUSTOM_ACTION_OTHER");

        if (viewIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(viewIntent);
        }
    }

    /* Here we are explicitly telling our Intent to use FirstActivity. So this is an explicit, rather
       than implicit, intent. Notice how we are able to start FirstActivity via both explicit and
       implicit intents (like in the above methods)
    */
    public void explicitIntent(View view) {
        Intent explicitIntent = new Intent(this, FirstActivity.class);
        startActivity(explicitIntent);
    }
}
