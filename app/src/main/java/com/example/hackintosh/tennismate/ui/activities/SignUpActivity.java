package com.example.hackintosh.tennismate.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.dto.DataKeys;
import com.example.hackintosh.tennismate.dto.User;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.SignUpPresenter;
import com.example.hackintosh.tennismate.ui.view.SingnUpView;

import java.io.Serializable;

/**
 * Created by maxim on 11/11/17.
 */

public class SignUpActivity extends BaseActivity<SingnUpView, SignUpPresenter> implements SingnUpView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setPresenter();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        User serializable = (User) bundle.getSerializable(DataKeys.USER);
    }

    public void setPresenter() {
        super.setPresenter(new SignUpPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
