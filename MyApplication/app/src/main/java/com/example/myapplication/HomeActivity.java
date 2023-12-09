package com.example.myapplication;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    String[] arr = {"Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 1","Chapter 2","Chapter 3","Chapter 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.EXTRA_MOBILE_NUMBER);
        textView.setText("Welcome " + user);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
//        listView.setAdapter(ad);
        ServiceListAdapter ad = new ServiceListAdapter(this, R.layout.service_layout, arr);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //makeText(HomeActivity.this, "You Pressed the adapter view", LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, RecyclerActivity.class);
                startActivity(intent);

            }
        });
    }
}