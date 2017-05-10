package com.example.yf.listcitydemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yf.listcitydemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.gridView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("style","grid");
                intent.setClass(MainActivity.this,GridCityActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.listView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("style","list");
                intent.setClass(MainActivity.this,GridCityActivity.class);
                startActivity(intent);
            }
        });
    }
}
