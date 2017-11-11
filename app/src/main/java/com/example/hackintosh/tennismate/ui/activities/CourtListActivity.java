package com.example.hackintosh.tennismate.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtListPresenter;
import com.example.hackintosh.tennismate.ui.presenters.SignUpPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtListView;
import com.example.hackintosh.tennismate.ui.view.SingnUpView;

/**
 * Created by maxim on 11/11/17.
 */

public class CourtListActivity extends BaseActivity<CourtListView, CourtListPresenter> implements CourtListView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setPresenter();
    }

    public void setPresenter() {
        super.setPresenter(new CourtListPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
