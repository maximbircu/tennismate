package com.example.hackintosh.tennismate.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.dto.Court;
import com.example.hackintosh.tennismate.ui.activities.CourtInfoActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hackintosh on 11/11/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Court> mDataset;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        @BindView(R.id.myText)
        public TextView mTextView;
        @BindView(R.id.elementImage)
        ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            this.view = v;
            ButterKnife.bind(this, v);
        }
    }

    public RecyclerViewAdapter(List<Court> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_element, parent, false);

        context = v.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        List<Integer> courts = null; // = new ArrayList<>();

        Court court = mDataset.get(position);

        holder.mTextView.setText(court.getTitle());
        courts = court.getTerrains();

        Picasso.with(context).load(court.getImageUrl()).into(holder.imageView);


        LinearLayout dataLayout = (LinearLayout) holder.view.findViewById(R.id.dataContainer);
        dataLayout.removeAllViews();

        for(int i = 0; i < courts.size(); i++) {
            TextView mTextView = new TextView(context);
            String fieldName = "Field No. " + courts.get(i);
            mTextView.setText(fieldName);
            mTextView.setTextColor(Color.GRAY);
            mTextView.setOnClickListener(v -> {
                Intent intent = new Intent(context, CourtInfoActivity.class);
                intent.putExtra("court", holder.mTextView.getText());
                intent.putExtra("field", mTextView.getText());
                context.startActivity(intent);
            });
            dataLayout.addView(mTextView);
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
