package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String category1 = extras.getString("fictionkey");
            String category2 = extras.getString("historykey");
            String category3 = extras.getString("businesskey");
            if(category1 == null){
                category1 = "temp1";
            }
            if(category2 == null){
                category2 = "temp2";
            }

            if(category1.equals("fiction")){
                List<Book> booksList = DataProvider.getBooks();
                BookAdapter itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            else if(category2.equals("history")){
                List<Book> booksList = DataProvider.getFictionBooks();
                BookAdapter itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            else if(category3.equals("business")){
                List<Book> booksList = DataProvider.getBusinessBooks();
                BookAdapter itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
        }



    }
}