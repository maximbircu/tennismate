package com.example.hackintosh.tennismate.ui.activities;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.dto.LevelEnum;
import com.example.hackintosh.tennismate.dto.User;
import com.example.hackintosh.tennismate.ui.adapters.CardsAdapter;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.MateFinerPresenter;
import com.example.hackintosh.tennismate.ui.view.MateFinderView;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PartnerFinderActivity extends BaseAuthenticatedActivity<MateFinderView, MateFinerPresenter> implements MateFinderView {

    private CardsAdapter cardsAdapter;
    private int i;


    @BindView(R.id.frame)
    protected SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_partner_finder);
        ButterKnife.bind(this);
        initSwipeCards();
    }

    private void initSwipeCards() {
        cardsAdapter = new CardsAdapter(Arrays.asList(
                new User("mail",Short.valueOf("123"), "Ivan Papusoi", LevelEnum.ADVANCED, "test")
        ));

        flingContainer.setAdapter((Adapter) cardsAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                cardsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
//                makeToast(PartnerFinderActivity.this, "Left!");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
//                makeToast((Conte)this, "Right!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                cardsAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
//                makeToast(MyActivity.this, "Clicked!");
            }

        });
    }



    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    public void setPresenter() {
        super.setPresenter(new MateFinerPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
