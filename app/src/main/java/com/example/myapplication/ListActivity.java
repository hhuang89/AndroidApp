package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listView,listView2;
    BookAdapter itemsAdapter;
    BookAdapter fictionAdapter;
    List<Book> fiction = DataProvider.getBooks();





    public static final String BOOK_DETAIL_KEY = "book";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        fictionAdapter = new BookAdapter(this, R.layout.activity_list, fiction);
        listView2 = (ListView) findViewById(R.id.listView);
        listView2.setAdapter(fictionAdapter);

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
                itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            else if(category2.equals("history")){
                List<Book> booksList = DataProvider.getFictionBooks();
                itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            else if(category3.equals("business")){
                List<Book> booksList = DataProvider.getBusinessBooks();
                itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            setupBookSelectedListener();
        }
    }

    public void setupBookSelectedListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                Object item = itemsAdapter.mBooks.get(position);
                intent.putExtra(BOOK_DETAIL_KEY, itemsAdapter.mBooks.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        final MenuItem item = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                item.collapseActionView();

                //complete SearchActivity by yourself

                // Set activity title to search query
                ListActivity.this.setTitle(query);
                return true;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    // Clear the text filter.
                    listView2.clearTextFilter();
                } else {
                    // Sets the initial value for the text filter.
                    listView2.setFilterText(newText.toString());
                }

                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}