package com.example.toolbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = this.findViewById(R.id.my_toolbar);

        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "Selected 'Search'", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_profile:
                Toast.makeText(MainActivity.this, "Selected 'Profile'", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Selected 'Setting'", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_help:
                Toast.makeText(MainActivity.this, "Selected 'Help'", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_sign_out:
                Toast.makeText(MainActivity.this, "Selected 'Sign Out'", Toast.LENGTH_SHORT).show();
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}
