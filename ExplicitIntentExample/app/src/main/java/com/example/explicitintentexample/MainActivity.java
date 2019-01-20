package com.example.explicitintentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* This will be used for as key used for data in our Intent. It is a good idea to use a public
       constant variable if you are going to be reading the Intent data from an Activity within your
       app
     */
    public static final String MAIN_ACTIVITY_COLOR_EXTRA = "color";

    /* When we do startActivityForResult(), we need to pass along a "request code". The called
       Activity will pass back the same code in its setResult() method, and we will read this
       value in the calling activity (in its onActivityResult() method) so we can tell where the
       result is coming from
     */
    public static final int MAIN_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Fire Intent and pass data using putExtra(). Use this instead of putExtras(bundle) if you
       don't have a lot of data to pass or if it's just simple primitive data types
    */
    public void fireIntentWithExtraData(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MAIN_ACTIVITY_COLOR_EXTRA, "yellow");
        startActivity(intent);
    }

    /* Fire Intent and pass data using putExtras(bundle). Use this instead of putExtra() if you have
       a lot of data to pass
    */
    public void fireIntentWithBundleData(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(MAIN_ACTIVITY_COLOR_EXTRA, "red");

        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void fireIntentAndGetResult(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(MAIN_ACTIVITY_COLOR_EXTRA, "blue");

        intent.putExtras(bundle);

        startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAIN_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String returnedColor = data.getStringExtra(ThirdActivity.SHOW_COLOR_RETURN_VALUE);
                Toast.makeText(MainActivity.this, returnedColor, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
