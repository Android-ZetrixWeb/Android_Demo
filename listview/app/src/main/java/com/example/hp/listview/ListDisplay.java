package com.example.hp.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.attr.x;
import static android.view.View.X;

public class ListDisplay extends AppCompatActivity {





        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_list_display, mobileArray);


            ListView listView = (ListView) findViewById(R.id.mobile_list);
            listView.setAdapter(adapter);
        }
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_list_display, mobileArray);

            ListView listView = (ListView) findViewById(R.id.mobile_list);
            listView.setAdapter(adapter);
        }
    }
}
