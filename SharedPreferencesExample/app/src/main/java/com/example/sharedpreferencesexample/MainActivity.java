package com.example.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    /* Save a reference to your app's SharedPreferences as an instance variable to make it
       easy to use in lifecycle methods
     */
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* PreferenceManager.getDefaultSharedPreferences is the best way to get a reference
           to our app's shared preferences, as it uses MODE_PRIVATE by default and a filename
           unique to your app
        */
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        /* Retrieve values from SharedPreferences using methods analogous to the methods you use to
           save them. The second argument is a default value, if the preference is not found. Before
           we call onPause() for the first time, the default values will be returned (since we
           haven't actually set any preferences yet)
        */
        String savedColor = mSharedPreferences.getString("color", "DEFAULT_RED");
        mSharedPreferences.getInt("number", 21231);
        mSharedPreferences.getFloat("myFloat", (float) 31.3);
        mSharedPreferences.getBoolean("myBool", false);
        mSharedPreferences.getLong("myLong", 624L);
        mSharedPreferences.getStringSet("myStringSet", new HashSet<String>());

        /* The first time you run this app, this will show "DEFAULT_RED" since we haven't yet called
           onPause and saved an actual value. To see the value change, do something to have onPause()
           called (such as closing the app), then re-open it. This Toast will now show "red". You
           will only see "DEFAULT_RED" called the first time you even open the app, since closing the
           app will update the values, and they persists across app (or even device) restarts. So the
           only way to see "DEFAULT_RED" again is to uninstall and re-install the app.
        */
        Toast.makeText(this, savedColor, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        /* Use the edit() method on your SharedPreferences instance variable to begin editing.
           This returns a SharedPreferences.Editor
         */
        SharedPreferences.Editor preferencesEditor = mSharedPreferences.edit();

        /* SharedPreferences.Editor has many methods to save preference values of different types */
        preferencesEditor.putString("color", "red");
        preferencesEditor.putInt("number", 21231);
        preferencesEditor.putFloat("myFloat", (float) 31.3);
        preferencesEditor.putBoolean("myBool", false);
        preferencesEditor.putLong("myLong", 624L);

        Set<String> strings = new HashSet<>();
        strings.add("mySetValue1");
        strings.add("mySetValue2");
        strings.add("mySetValue3");
        strings.add("mySetValue4");
        preferencesEditor.putStringSet("myStringSet", strings);

        /* Save the new preferences values with apply(). You could also call commit() but that is a
        blocking method and is not recommended
         */
        preferencesEditor.apply();

        Toast.makeText(this, "Updated shared preferences", Toast.LENGTH_SHORT).show();

    }
}
