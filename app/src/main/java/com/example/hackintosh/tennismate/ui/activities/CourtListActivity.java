package com.example.hackintosh.tennismate.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtListPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtListView;

/**
 * Created by maxim on 11/11/17.
 */

public class CourtListActivity extends BaseAuthenticatedActivity<CourtListView, CourtListPresenter> implements CourtListView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_court_list);
    }

    public void setPresenter() {
        super.setPresenter(new CourtListPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
