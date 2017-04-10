package com.example.mayankchauhan.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by mayankchauhan on 22/02/17.
 */

public class MyAsyncTAsk extends AsyncTask<Void,Integer,String> {

    Context context;
    TextView textView;
    Button button;
    ProgressDialog progressDialog;

    public MyAsyncTAsk(Button button, TextView textView, Context context) {
        this.button = button;
        this.textView = textView;
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        int i =0;
        synchronized (this)
        {
            while (i<10)
            {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return "DOWNLOAD COMPLETE ...";
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("DOWNLOAD IN PROGRESS .....");
        progressDialog.setProgress(0);
        progressDialog.setMax(10);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {
        textView.setText(result);
        button.setEnabled(true);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        int progress = values[0];
        progressDialog.setProgress(progress);
        textView.setText("DOWNLOAD IN PROGRESS");
    }
}
