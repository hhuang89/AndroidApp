package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailActivity extends AppCompatActivity {
    CarouselView carouselView;
    TextView adTitle;
    TextView adAuthor;
    int[] resID;
    Book book;
    public static int REQUEST_UPDATE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        adTitle = (TextView) findViewById(R.id.adTitle);
        adAuthor = (TextView) findViewById(R.id.adAuthor);

        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra(ListActivity.BOOK_DETAIL_KEY);
        loadBook(book);
    }

    private void loadBook(Book book) {
        //change activity title

        //this.setTitle(book.getTitleName());
        adTitle.setText(book.getTitleName());
        adAuthor.setText(book.getAuthorName());

        int i = getResources().getIdentifier(
                book.getBookCoverName(), "drawable",
                getPackageName());
        int j = getResources().getIdentifier(
                book.getImage2(), "drawable",
                getPackageName());
        int z = getResources().getIdentifier(
                book.getImage3(), "drawable",
                getPackageName());
        resID = new int[]{i,j,z};
        carouselView.setPageCount(resID.length);
        carouselView.setImageListener(imageListener);
        book.setCount(book.getCount()+1);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(resID[position]);
        }
    };

    @Override
    public void onBackPressed() {
        //MainActivity.toppicks = MainActivity.sortView();
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra(ListActivity.BOOK_DETAIL_KEY, book);
        setResult(RESULT_OK, intent);
        finish();
    }
}
