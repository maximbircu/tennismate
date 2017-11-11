package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;

import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.SplashPresenter;
import com.example.hackintosh.tennismate.ui.view.SplashView;


public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    public void setPresenter() {
        super.setPresenter(new SplashPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
