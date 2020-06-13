package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    List<Book> mBooks;
    Context mContext;
    LayoutInflater mInflater;

    public RecycleViewAdapter(Context context, List objects){
        this.mInflater = LayoutInflater.from(context);
        this.mBooks = objects;
        this.mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.top3_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Book book = mBooks.get(position);
        int i = mContext.getResources().getIdentifier(
                book.getBookCoverName(), "drawable",
                mContext.getPackageName());
        viewHolder.top.setImageResource(i);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView top;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            top = (ImageView) itemLayoutView.findViewById(R.id.top);
        }
    }
    //total number of books to show
    @Override
    public int getItemCount() {
        return 3;
    }

    public void updateRecycleView(List<Book> object){
        this.mBooks = object;
        notifyDataSetChanged();
    }
}
