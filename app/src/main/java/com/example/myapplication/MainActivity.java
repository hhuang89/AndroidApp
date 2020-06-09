package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fictionButton = (Button) findViewById(R.id.button);
        fictionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getBaseContext(), ListActivity.class);
                String fiction = "fiction";
                listIntent.putExtra("fictionkey", fiction);
                startActivity(listIntent);
            }
        });

        Button historyButton = (Button) findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent historyListView = new Intent(getBaseContext(), ListActivity.class);
                String history = "history";
                historyListView.putExtra("historykey", history);
                startActivity(historyListView);
            }
        });

        Button businessButton = (Button) findViewById(R.id.business_button);
        businessButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent businessListView = new Intent(getBaseContext(), ListActivity.class);
                String business = "business";
                businessListView.putExtra("businesskey", business);
                startActivity(businessListView);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
