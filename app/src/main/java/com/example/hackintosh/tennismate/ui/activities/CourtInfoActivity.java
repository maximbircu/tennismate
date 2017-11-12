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


public class CourtInfoActivity extends BaseAuthenticatedActivity<CourtInfoView, CourtInfoPresenter> implements CourtInfoView {

    private String court;
    private String field;

    @BindView(R.id.court)
    TextView courtText;

    @BindView(R.id.field)
    TextView fieldText;

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
        ButterKnife.bind(this);
        setupActivity();
    }

    public void setPresenter() {
        super.setPresenter(new CourtInfoPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    public void setupActivity() {
        Intent intent = getIntent();
        court = intent.getStringExtra("court");
        field = intent.getStringExtra("field");

        courtText.setText(court);
        fieldText.setText(field);
    }
}
