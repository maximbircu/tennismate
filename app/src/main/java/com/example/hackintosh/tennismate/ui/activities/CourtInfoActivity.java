package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtInfoPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtInfoView;


public class CourtInfoActivity extends BaseAuthenticatedActivity<CourtInfoView, CourtInfoPresenter> implements CourtInfoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
        this.toolbarTitle = "Court info";
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_court_info);
    }

    public void setPresenter() {
        super.setPresenter(new CourtInfoPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
