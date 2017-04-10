package com.example.mayankchauhan.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        MyAsyncTAsk asyncTAsk = new MyAsyncTAsk(button,textview,MainActivity.this);
        asyncTAsk.execute();
        button.setEnabled(false);

    }
}
