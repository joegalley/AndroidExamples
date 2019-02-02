package com.example.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBackgroundTask(View view) {
        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute("Sending some data to MyAsyncTask...");
    }

}
