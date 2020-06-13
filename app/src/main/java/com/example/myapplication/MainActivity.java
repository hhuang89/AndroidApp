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
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    static List<Book> Fiction = DataProvider.getFictionBooks();
    static List<Book> Business = DataProvider.getBusinessBooks();
    static List<Book> History = DataProvider.getHistoryBooks();
    static List<Book> toppicks;

    public static final String updateRecycleViewKey = "book";
    RecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toppicks = sortView();
        //RecycleView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.top3View);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager.setReverseLayout(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecycleViewAdapter(this, toppicks);
        recyclerView.setAdapter(adapter);

        Button fictionButton = (Button) findViewById(R.id.button);
        fictionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getBaseContext(), ListActivity.class);
                String fiction = "fiction";
                listIntent.putExtra("fictionkey", fiction);
                startActivityForResult(listIntent, ListActivity.REQUEST_UPDATE);
            }
        });

        Button historyButton = (Button) findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent historyListView = new Intent(getBaseContext(), ListActivity.class);
                String history = "history";
                historyListView.putExtra("historykey", history);
                startActivityForResult(historyListView, ListActivity.REQUEST_UPDATE);
            }
        });

        Button businessButton = (Button) findViewById(R.id.business_button);
        businessButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent businessListView = new Intent(getBaseContext(), ListActivity.class);
                String business = "business";
                businessListView.putExtra("businesskey", business);
                startActivityForResult(businessListView, ListActivity.REQUEST_UPDATE);
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

    static public List<Book> sortView(){
        ArrayList<Book> TopPicks  = new ArrayList<>();
        for (int i = 0; i < Fiction.size()-1; i++){
            for (int j = 0; j < Fiction.size()-i-1; j++) {
                if (Fiction.get(j).getCount() < Fiction.get(j + 1).getCount()) {
                    Book temp = Fiction.get(j);
                    Fiction.set(j, Fiction.get(j + 1));
                    Fiction.set(j + 1, temp);
                }
            }
        }

        for (int i = 0; i < Business.size()-1; i++){
            for (int j = 0; j < Business.size()-i-1; j++) {
                if (Business.get(j).getCount() < Business.get(j + 1).getCount()) {
                    Book temp = Business.get(j);
                    Business.set(j, Business.get(j + 1));
                    Business.set(j + 1, temp);
                }
            }
        }

        for (int i = 0; i < History.size()-1; i++){
            for (int j = 0; j < History.size()-i-1; j++) {
                if (History.get(j).getCount() < History.get(j + 1).getCount()) {
                    Book temp = History.get(j);
                    History.set(j, History.get(j + 1));
                    History.set(j + 1, temp);
                }
            }
        }

        for(int i = 0; i < 10; i++){
            TopPicks.add(Fiction.get(i));
            TopPicks.add(Business.get(i));
            TopPicks.add(History.get(i));
        }

        for (int i = 0; i < TopPicks.size()-1; i++){
            for (int j = 0; j < TopPicks.size()-i-1; j++) {
                if (TopPicks.get(j).getCount() < TopPicks.get(j + 1).getCount()) {
                    Book temp = TopPicks.get(j);
                    TopPicks.set(j, TopPicks.get(j + 1));
                    TopPicks.set(j + 1, temp);
                }
            }
        }
        return TopPicks;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (requestCode == ListActivity.REQUEST_UPDATE){
                adapter.updateRecycleView((List<Book>) data.getSerializableExtra(updateRecycleViewKey));
            }
        }
    }
}
