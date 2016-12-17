package com.example.hp.appdrowerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2);
        Intent intent=getIntent();

       String activityname= intent.getStringExtra("Activtyname");
        Toast.makeText(this, "Welcome to "+activityname, Toast.LENGTH_SHORT).show();
    }
}
