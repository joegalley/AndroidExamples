package com.example.asynctaskexample;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/*
    The generic types here (String, Integer, and Void> mean:
    - String: The type of object we want to give to the AsyncTask. This is the argument type ford doInBackground()
    - Integer: The type to handle in onProgressUpdate(). In this AsyncTask, we want to update MainActivity's
        ProgressBar, which takes an integer value to represent progress, hence we use Integer
    - Void: We don't actually want to return anything from this AsyncTask, we this is Void. This is
        the argument that goes to onPostExecute()
 */
public class MyAsyncTask extends AsyncTask<String, Integer, Void> {

    /* Keep WeakReferences to MainActivity (the Context that invoked this AsyncTask and its
       ProgressBar view. See https://medium.com/google-developer-experts/finally-understanding-how-references-work-in-android-and-java-26a0d9c92f83
       for an explanation of WeakReference.
     */

    private final WeakReference<MainActivity> mMainActivity;
    private final WeakReference<ProgressBar> mProgressBar;

    public MyAsyncTask(Context context) {
        this.mMainActivity = new WeakReference<>((MainActivity) context);

        ProgressBar progressBar = mMainActivity.get().findViewById(R.id.progressBar);

        this.mProgressBar = new WeakReference<ProgressBar>(progressBar);
    }

    @Override
    protected Void doInBackground(String... params) {
        for (int i = 0; i < 7; i++) {
            try {

                // Wait for 1 second in between progress updates
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            this.onProgressUpdate(i);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // Say when the tasks is completed
        Toast.makeText(this.mMainActivity.get(), "Done!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPreExecute() {
        // If the task has already been run, reset the progress to 0 so we can start over
        mProgressBar.get().setProgress(0);

        Toast.makeText(this.mMainActivity.get(), "AsyncTask starting...", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        int currentProgress = this.mProgressBar.get().getProgress();

        // We're 1 step closer to finishing the task
        mProgressBar.get().setProgress(currentProgress + 1, true);
    }
}