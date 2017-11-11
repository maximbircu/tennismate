package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.RandomPartnerFinderPresenter;
import com.example.hackintosh.tennismate.ui.view.RandomPartnerFinderView;


public class RandomPartnerFinderActivity extends BaseAuthenticatedActivity<RandomPartnerFinderView, RandomPartnerFinderPresenter> implements RandomPartnerFinderView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_random_partner_finder);
    }

    public void setPresenter() {
        super.setPresenter(new RandomPartnerFinderPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
