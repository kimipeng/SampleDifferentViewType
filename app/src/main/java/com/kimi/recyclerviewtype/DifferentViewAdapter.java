package com.kimi.recyclerviewtype;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kimipon on 2017/8/29.
 */

public class DifferentViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int ODD = 1;
    public static final int EVEN = 0;


    public class OddViewHolder extends RecyclerView.ViewHolder {

        public TextView oddTextView;

        public OddViewHolder(View itemView) {
            super(itemView);
            oddTextView = (TextView) itemView.findViewById(R.id.oddTextView);
        }

    }

    public class EvenViewHolder extends RecyclerView.ViewHolder {

        public TextView evenTextView;

        public EvenViewHolder(View itemView) {
            super(itemView);
            evenTextView = (TextView) itemView.findViewById(R.id.evenTextView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return ++position % 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (ODD == viewType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_odd_layout, parent, false);
            return new OddViewHolder(view);
        } else  { // EVEN == viewType
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_even_layout, parent, false);
            return new EvenViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof OddViewHolder) {
            OddViewHolder oddViewHolder = (OddViewHolder) holder;
            oddViewHolder.oddTextView.setText(String.format("我是第%s格位置的OddViewHolder.", ++position));

        } else if (holder instanceof EvenViewHolder) {
            EvenViewHolder evenViewHolder = (EvenViewHolder) holder;
            evenViewHolder.evenTextView.setText(String.format("我是第%s格位置的EddViewHolder.", ++position));
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
