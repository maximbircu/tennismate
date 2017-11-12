package com.example.hackintosh.tennismate.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtInfoPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtInfoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CourtInfoActivity extends BaseAuthenticatedActivity<CourtInfoView, CourtInfoPresenter> implements CourtInfoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_court_info);
        ButterKnife.bind(this);
        setupActivity();
    }

    public void setPresenter() {
        super.setPresenter(new CourtInfoPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    public void setupActivity() {
        Intent intent = getIntent();
        this.drawerController.toolbar.setTitle(intent.getStringExtra("field") + " - "+intent.getStringExtra("court"));

    }

    @OnClick(R.id.bookCourt)
    public void onBook(){
        presenter.navigator.openPartnerFinderActivity();
    }
}
