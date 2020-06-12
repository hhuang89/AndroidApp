package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    static List<Book> Fiction = DataProvider.getFictionBooks();
    static List<Book> Business = DataProvider.getBusinessBooks();
    static List<Book> History = DataProvider.getHistoryBooks();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecycleView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.top3View);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, Fiction);
        recyclerView.setAdapter(adapter);

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


}
