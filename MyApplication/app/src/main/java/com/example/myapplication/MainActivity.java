package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MOBILE_NUMBER = "com.example.myapplication.extra.MOBILE_NUMBER";
    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPassword2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String mobileNumber = editText.getText().toString();
                if (mobileNumber.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter mobile number", Toast.LENGTH_SHORT).show();
                } else if (mobileNumber.chars().count() != 10) {
                    Toast.makeText(MainActivity.this, "Please Enter valid 10 digit mobile number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this ,HomeActivity.class);
                    intent.putExtra(EXTRA_MOBILE_NUMBER, mobileNumber);
                    startActivity(intent);
                }
            }
        });
    }
}