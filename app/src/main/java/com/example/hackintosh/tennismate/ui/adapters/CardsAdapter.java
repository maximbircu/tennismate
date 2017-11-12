package com.example.hackintosh.tennismate.ui.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.dto.User;
import com.example.hackintosh.tennismate.ui.viewholders.CardViewHolder;
import com.example.hackintosh.tennismate.utils.CircleTransform;
import com.example.hackintosh.tennismate.utils.DrawableHelper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

/**
 * Created by maxim on 11/12/17.
 */

public class CardsAdapter extends BaseAdapter {

    private final List<User> users;

    public CardsAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        }

        User user = users.get(i);

        CardViewHolder cardViewHolder = new CardViewHolder(view);
        cardViewHolder.fullName.setText(user.getFullName());
        cardViewHolder.age.setText(user.getAge()+"");
        cardViewHolder.level.setText(user.getLevel()+"");


        Picasso.with(viewGroup.getContext())
                .load(user.getImageUrl())
                .transform(new CircleTransform(false))
                .into(cardViewHolder.image);


        return view;
    }
}
