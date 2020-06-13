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


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listView,searchView;
    public static BookAdapter itemsAdapter;
    BookAdapter resultAdapter;
    public int adapterUpdateItemPosition;
    boolean fictionSearch = false;
    boolean historySearch = false;
    boolean businessSearch = false;
    boolean textset;
    List<Book> fiction = MainActivity.Fiction;
    List<Book> history = MainActivity.History;
    List<Book> business = MainActivity.Business;



    public static final String BOOK_DETAIL_KEY = "book";
    public static final int REQUEST_UPDATE = 20;
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
                List<Book> booksList = MainActivity.Fiction;
                fictionSearch = true;
                itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            else if(category2.equals("history")){
                List<Book> booksList = MainActivity.History;
                historySearch = true;
                itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                        booksList);
                listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(itemsAdapter);
            }
            else {
                assert category3 != null;
                if(category3.equals("business")){
                    List<Book> booksList = MainActivity.Business;
                    businessSearch = true;
                    itemsAdapter = new BookAdapter(this, R.layout.relative_layout,
                            booksList);
                    listView = (ListView) findViewById(R.id.listView);
                    listView.setAdapter(itemsAdapter);
                }
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
                adapterUpdateItemPosition = position;
                if (textset){
                    intent.putExtra(BOOK_DETAIL_KEY, resultAdapter.mBooks.get(position));
                }else{
                    intent.putExtra(BOOK_DETAIL_KEY, itemsAdapter.mBooks.get(position));
                }
                //startActivity(intent);
                startActivityForResult(intent, DetailActivity.REQUEST_UPDATE);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search, menu);
//        final MenuItem item = menu.findItem(R.id.search);
//        final SearchView searchView = (SearchView) item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                List<Book> results = new ArrayList<>();
//                if (newText != null){
//                    textset = true;
//                }else{
//                    textset = false;
//                }
//                if (fictionSearch){
//                    for (Book x:fiction){
//                        if (x.getTitleName().toLowerCase().contains(newText.toLowerCase())){
//                            results.add(x);
//                        }
//                    }
//                    resultAdapter = new BookAdapter(ListActivity.this,R.layout.relative_layout,results);
//                    resultAdapter.update(results);
//                    listView.setAdapter(resultAdapter);
//                }else if (historySearch){
//                    for (Book x:history){
//                        if (x.getTitleName().toLowerCase().contains(newText.toLowerCase())){
//                            results.add(x);
//                        }
//                    }
//                    resultAdapter = new BookAdapter(ListActivity.this,R.layout.relative_layout,results);
//                    resultAdapter.update(results);
//                    listView.setAdapter(resultAdapter);
//                }else if (businessSearch){
//                    for (Book x:business){
//                        if (x.getTitleName().toLowerCase().contains(newText.toLowerCase())){
//                            results.add(x);
//                        }
//                    }
//                    resultAdapter = new BookAdapter(ListActivity.this,R.layout.relative_layout,results);
//                    resultAdapter.update(results);
//                    listView.setAdapter(resultAdapter);
//                }
//                return false;
//            }
//        });
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.search){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (requestCode == DetailActivity.REQUEST_UPDATE){
                itemsAdapter.updateListView(adapterUpdateItemPosition, (Book) data.getSerializableExtra(BOOK_DETAIL_KEY));
                //resultAdapter.updateListView(adapterUpdateItemPosition, (Book) data.getSerializableExtra(BOOK_DETAIL_KEY));
            }
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
//        MainActivity.toppicks = MainActivity.sortView();
        intent.putExtra(MainActivity.updateRecycleViewKey, (Serializable) MainActivity.toppicks);
        setResult(RESULT_OK, intent);
        finish();
    }
}