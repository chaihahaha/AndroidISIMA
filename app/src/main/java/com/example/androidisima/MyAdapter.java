package com.example.androidisima;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private CatFacts mDataset;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
    public MyAdapter(CatFacts mDataset) {
        this.mDataset = mDataset;
    }
    @NotNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.data[position].fact);
    }
    @Override
    public int getItemCount() {
        return mDataset.data.length;
    }
}
