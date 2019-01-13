package com.example.viewsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use findViewById() to get a reference to the checkbox with id "myCheckbox"
        CheckBox checkBox = this.findViewById(R.id.myCheckbox);

        /* - CheckBox's setOnCheckedChangeListener() method allow you to listen for checking and
             un-checking itself. When you check the box, we will display "checked" in a Toast, when
             it is un-checked, we will display "unchecked".

           - This is one way to set a listener for a View. The other was is directly in the XML
             layout file, as we do for the Button and its myButtonOnClick() method below.
         */
        checkBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        /* - The first parameter to makeText() is a Context object. Since the
                            listener is of type OnCheckedChangeListener, which does not extend from
                            the Context object, we must use "MainActivity.this" instead of just "this"
                            (since MainActivity extends the Context object).

                            - This is a common pattern when implementing interfaces for View callbacks
                         */

                        Toast.makeText(MainActivity.this, isChecked ? "checked" : "unchecked", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    /* Executed when the Button from activity_main.xml is clicked. This is an example of defining
       a View callback method directly in the XML layout file. Contrast with how we wire up the callback
       in Java code for the CheckBox above.
     */
    public void myButtonOnClick(View view) {
        Toast.makeText(this, "You clicked the button!", Toast.LENGTH_SHORT).show();
    }
}
