package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;
import android.util.Log;

import com.example.hackintosh.tennismate.service.CourtsServices;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.SplashPresenter;
import com.example.hackintosh.tennismate.ui.view.SplashView;


public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();

        CourtsServices courtsServices = new CourtsServices();

        courtsServices.getCourts(data -> {
            Log.d("WTF", "Received "+data.size());
        }, err -> {
            Log.d("WTF",err);
        });
    }

    public void setPresenter() {
        super.setPresenter(new SplashPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
