package com.example.explicitintentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.explicitintentexample.R;

import static com.example.explicitintentexample.MainActivity.MAIN_ACTIVITY_COLOR_EXTRA;


public class ThirdActivity extends AppCompatActivity {

    // A key for passing back data from this Activity to its calling activity via an Intent
    public static final String SHOW_COLOR_RETURN_VALUE = "returnValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    /* When Button with id btn_send_back_data is pressed, this method will be executed, finishing
       ThirdActivity and returning some data to MainActivity. Once finish() is called, ThirdActivity
       will be popped off the back stack and cease to exist.
     */
    public void sendDataToCallingActivity(View view) {
        // Get the incoming (calling) intent
        Intent incomingIntent = this.getIntent();
        String incomingColor = incomingIntent.getStringExtra(MAIN_ACTIVITY_COLOR_EXTRA);

        // The incoming value will be blue, so we're going to return "bluegreen" from the activity
        String returnColor = incomingColor + "green";

        /* If the Activity was started via getActivityForResult(), then getCallingActivity() will
           not be null. If the Activity was started with just startActivity(), then it will be null
        */
        if (null != getCallingActivity()) {

            /* Create a new Intent to pass back. Technically we could pass back the same Intent that
               started this Activity, but that may lead to confusion
             */
            Intent returnIntent = new Intent();

            // Set some data to pass back to the calling Activity ("bluegreen")
            returnIntent.putExtra(SHOW_COLOR_RETURN_VALUE, returnColor);

            // Everything went fine - return RESULT_OK
            setResult(RESULT_OK, returnIntent);

            // finish this Activity, passing back control to the calling Activity
            finish();
        }
    }
}
