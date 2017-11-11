package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.MateFinerPresenter;
import com.example.hackintosh.tennismate.ui.view.MateFinderView;


public class PartnerFinderActivity extends BaseAuthenticatedActivity<MateFinderView, MateFinerPresenter> implements MateFinderView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_partner_finder);
    }

    public void setPresenter() {
        super.setPresenter(new MateFinerPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
