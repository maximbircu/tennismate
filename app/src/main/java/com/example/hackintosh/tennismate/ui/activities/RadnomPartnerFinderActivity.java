package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.PartnerFinderPresenter;
import com.example.hackintosh.tennismate.ui.view.PartnerFinderView;


public class RadnomPartnerFinderActivity extends BaseActivity<PartnerFinderView, PartnerFinderPresenter> implements PartnerFinderView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_partner_finder);
        setPresenter();
    }

    public void setPresenter() {
        super.setPresenter(new PartnerFinderPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
