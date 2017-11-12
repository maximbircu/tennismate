package com.example.hackintosh.tennismate.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hackintosh.tennismate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maxim on 11/12/17.
 */

public class CardViewHolder {

    @BindView(R.id.user_full_name )
    public TextView fullName;

    @BindView(R.id.user_age)
    public TextView age;

    public CardViewHolder(View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
