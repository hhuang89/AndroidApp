package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookAdapter extends ArrayAdapter {

    int mLayoutID;
    List<Book> mBooks;
    Context mContext;


    public BookAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mContext = context;
        mBooks = objects;
    }

    public void update(List<Book> results){
        mBooks = new ArrayList<>();
        mBooks.addAll(results);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }
        //Get the Book object for the current position
        Book currentBook = mBooks.get(position);

        //Set the attributed of list_view_book_item views
        ImageView bookCoverImageView = (ImageView) currentListViewItem.findViewById(R.id.rlBookCover);
        int i = mContext.getResources().getIdentifier(
                currentBook.getBookCoverName(), "drawable",
                mContext.getPackageName());

        //Setting the bookCover
        bookCoverImageView.setImageResource(i);
        //author
        TextView authorTextView = (TextView) currentListViewItem.findViewById(R.id.rlAuthor);
        authorTextView.setText(currentBook.getAuthorName());
        //title
        TextView titleTextView = (TextView) currentListViewItem.findViewById(R.id.rlTitle);
        titleTextView.setText(currentBook.getTitleName());

        TextView numTextView = (TextView) currentListViewItem.findViewById(R.id.numView);
        String num = "The number of clicks:";
        numTextView.setText(num);

        //countView
        TextView viewTextView = (TextView) currentListViewItem.findViewById(R.id.rlView);
        viewTextView.setText(String.valueOf(currentBook.getCount()));

        return currentListViewItem;
    }

    public void updateListView(int position, Book book){
        Book book1 = (Book) getItem(position);
        book1.setCount(book.getCount());
        notifyDataSetChanged();
    }
}
