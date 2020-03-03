package com.example.startactivityforresultdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView textView2;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Activity2");
        Intent intent = getIntent();
        final int n1 = intent.getIntExtra("key1", 0);
        final int n2 = intent.getIntExtra("key2", 0);
        textView2 = findViewById(R.id.t2);
        textView2.setText("Numbers :" + n1 + "," + n2);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result=n1+n2;
                Intent resultintent=new Intent();
                resultintent.putExtra("key3",result);
                setResult(RESULT_OK,resultintent);
                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = n1 - n2;
                Intent resultintent = new Intent();
                resultintent.putExtra("key3", result);
                setResult(RESULT_OK, resultintent);
                finish();
            }
        });
    }
}
