package com.example.layoutexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLinearLayoutVertical(View view) {
        startActivity(new Intent(this, LinearLayoutVertical.class));
    }

    public void showLinearLayoutHorizontal(View view) {
        startActivity(new Intent(this, LinearLayoutHorizontal.class));
    }

    public void showTableLayout(View view) {
        startActivity(new Intent(this, TableLayout.class));
    }

    public void showRelativeLayout(View view) {
        startActivity(new Intent(this, RelativeLayout.class));
    }
}
