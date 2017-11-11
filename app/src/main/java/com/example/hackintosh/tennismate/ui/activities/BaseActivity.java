package com.example.hackintosh.tennismate.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.hackintosh.tennismate.ui.presenters.BasePresenter;
import com.example.hackintosh.tennismate.ui.view.BaseView;

/**
 * Created by maxim on 11/11/17.
 */

public abstract class BaseActivity<V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity {
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.destroy();
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
