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

public class ListActivity extends AppCompatActivity implements  Filterable{
    ListView listView;
    BookAdapter itemsAdapter;
    BookAdapter fictionAdapter;
    List<Book> fiction = DataProvider.getBooks();
    List<Book> fictionfiltered = DataProvider.getBooks();




    public static final String BOOK_DETAIL_KEY = "book";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        fictionAdapter = new BookAdapter(this, R.layout.relative_layout, fiction);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(fictionAdapter);

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
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


               itemsAdapter.getFilter().filter(newText);

                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length()==0){
                    filterResults.count = fiction.size();
                    filterResults.values = fiction;
                }else{
                    String searchStr = constraint.toString().toUpperCase();
                    List<Book>  resultData = new ArrayList<>();
                    for (Book Book:fiction){
                        if (Book.getTitleName().contains(searchStr)){
                            resultData.add(Book);
                        }
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                fictionfiltered = (List<Book>) results.values;


            }
        };
        return filter;
    }
}