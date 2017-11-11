package com.example.hackintosh.tennismate.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.LoginPresenter;
import com.example.hackintosh.tennismate.ui.view.LoginView;

/**
 * Created by maxim on 11/11/17.
 */

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setPresenter();
    }

    public void setPresenter() {
        super.setPresenter(new LoginPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
