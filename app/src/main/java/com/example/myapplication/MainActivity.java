package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    static List<Book> Fiction = DataProvider.getFictionBooks();
    static List<Book> Business = DataProvider.getBusinessBooks();
    static List<Book> History = DataProvider.getHistoryBooks();
    List<Book> toppicks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toppicks = sortView();
        //RecycleView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.top3View);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        //linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, toppicks);
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
        Button Searchbutton = (Button) findViewById(R.id.Searchbutton);
        Searchbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Search = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(Search);
            }
        });
    }
    public List<Book> sortView(){
        List<Book> books =Fiction;
        ArrayList<Book> sortedList  = new ArrayList<>();
        ArrayList<Book> TopPicks  = new ArrayList<>();
        books.addAll(Business);
        books.addAll(History);

        ArrayList<Integer> NumberOfClicks = new ArrayList<Integer>();

        for (Book x:books){
            NumberOfClicks.add(x.getCount());
        }

        Collections.sort(NumberOfClicks);
        for (Book x:books){
            NumberOfClicks.add(x.getCount());
        }
        for (int y:NumberOfClicks){
            for (Book x:books){
                if (x.getCount()==y){
                    sortedList.add(x);
                }
            }
        }
        Collections.reverse(sortedList);
        TopPicks.add(sortedList.get(0));
        TopPicks.add(sortedList.get(1));
        TopPicks.add(sortedList.get(2));
        return TopPicks;
    }

}
