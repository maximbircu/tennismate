package com.example.hackintosh.tennismate.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hackintosh.tennismate.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hackintosh on 11/11/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.myText)
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

                    }
    }

    public RecyclerViewAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_element, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
