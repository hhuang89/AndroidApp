package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ListView searchbooks;
    public int adapterUpdateItemPosition;
    List<Book> fiction = MainActivity.Fiction;
    List<Book> history = MainActivity.History;
    List<Book> business = MainActivity.Business;
    public static BookAdapter adapter;
    BookAdapter resultadapter;
    ArrayList<Book> books = new ArrayList<>();
    boolean textset;

    public static final String BOOK_DETAIL_KEY = "book";
    public static int REQUEST_UPDATE = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchbooks = (ListView) findViewById(R.id.searchbooks);
//        listView.setAdapter(adapter);

        books.addAll(fiction);
        books.addAll(history);
        books.addAll(business);
//        adapter = new BookAdapter(this, R.layout.relative_layout,
//                books);
//        searchbooks.setAdapter(adapter);


        setupBookSelectedListener();
    }

    public void setupBookSelectedListener() {
        searchbooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                adapterUpdateItemPosition = position;

                intent.putExtra(BOOK_DETAIL_KEY, resultadapter.mBooks.get(position));



                startActivityForResult(intent, DetailActivity.REQUEST_UPDATE);
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
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null){
                    textset = true;
                }else{
                    textset = false;
                }
                List<Book> results = new ArrayList<>();

                    for (Book x:books){
                        if (x.getTitleName().toLowerCase().contains(newText.toLowerCase())){
                            results.add(x);
                        }
                    }
                    resultadapter = new BookAdapter(SearchActivity.this,R.layout.relative_layout,results);
                    searchbooks.setAdapter(resultadapter);
                    if (results.size() ==0){

                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "No matching books found",
                                    Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (requestCode == DetailActivity.REQUEST_UPDATE){
                resultadapter.updateListView(adapterUpdateItemPosition, (Book) data.getSerializableExtra(BOOK_DETAIL_KEY));

            }
        }
    }
    @Override
    public void onBackPressed() {
        MainActivity.toppicks = MainActivity.sortView();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.updateRecycleViewKey, (Serializable) MainActivity.toppicks);
        setResult(RESULT_OK, intent);
        finish();
    }

}
