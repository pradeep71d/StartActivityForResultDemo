package com.example.startactivityforresultdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    EditText editText1;
    EditText editText2;
    Button bu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.t1);
        editText1 = findViewById(R.id.e1);
        editText2 = findViewById(R.id.e2);
        bu1 = findViewById(R.id.b1);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "please insert numbers", Toast.LENGTH_SHORT).show();
                } else {
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("key1", num1);
                    intent.putExtra("key2", num2);
                    startActivityForResult(intent, 1);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int res = data.getIntExtra("key3", 0);
                textView1.setText("" + res);
            }
            if (requestCode == RESULT_CANCELED) {
                textView1.setText("nothing selected");
            }
        }
    }
}
