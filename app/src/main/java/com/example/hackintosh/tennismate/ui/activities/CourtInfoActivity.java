package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtInfoPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtInfoView;


public class CourtInfoActivity extends BaseActivity<CourtInfoView, CourtInfoPresenter> implements CourtInfoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_partner_finder);
        setPresenter();
    }

    public void setPresenter() {
        super.setPresenter(new CourtInfoPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
