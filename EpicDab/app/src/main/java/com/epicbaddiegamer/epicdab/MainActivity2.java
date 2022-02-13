package com.epicbaddiegamer.epicdab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public TextView txtbox1;
    public TextView txtbox2;
    public TextView txtbox3;
    public TextView txtbox4;
    public TextView txtbox5;
    public TextView txtbox6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        configureBackButton();

        txtbox1 = findViewById(R.id.textView1);
        txtbox2 = findViewById(R.id.textView2);
        txtbox3 = findViewById(R.id.textView3);
        txtbox4 = findViewById(R.id.textView4);
        txtbox5 = findViewById(R.id.textView5);
        txtbox6 = findViewById(R.id.textView6);

        Bundle bundle = getIntent().getExtras();
        int value = 0;
        if (bundle != null) {
            value = bundle.getInt("value");
        }

        if (value > 250) {
            txtbox1.setTextColor(Color.GREEN);
        }
        if (value > 500) {
            txtbox2.setTextColor(Color.GREEN);
        }
        if (value > 1000) {
            txtbox3.setTextColor(Color.GREEN);
        }
        if (value > 2500) {
            txtbox4.setTextColor(Color.GREEN);
        }
        if (value > 5000) {
            txtbox5.setTextColor(Color.GREEN);
        }
        if (value > 10000) {
            txtbox6.setTextColor(Color.GREEN);
        }
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }
        );
    }
}
