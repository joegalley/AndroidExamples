package com.example.explicitintentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView dataFromIntent = (TextView) findViewById(R.id.data_from_intent);

        // Retrieve the Intent that started this activity
        Intent incomingIntent = this.getIntent();

        String color;

        // Retrieve the data from the intent
        color = incomingIntent.getStringExtra(MainActivity.MAIN_ACTIVITY_COLOR_EXTRA);

        /* If the Intent sent a Bundle (as it does in fireIntentWithBundleData in MainActivity), you
           can retrieve the data with intent.getExtras(). You should check that getExtras() is not null
           before calling any more methods on it, because if it is null (meaning the Intent didn't send
           a Bundle), it will throw a NullPointerException.
         */
        Bundle extras = incomingIntent.getExtras();
        if (extras != null) {
            color = extras.getString(MainActivity.MAIN_ACTIVITY_COLOR_EXTRA);
        }

        /* Show the retrieved data in a TextView
           It will say "red" if the Intent was fired from fireIntentWithBundleData, or
           "yellow" if it was fired from "fireIntentWithExtraData"
         */
        dataFromIntent.setText(color);
    }
}
