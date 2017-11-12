package com.example.hackintosh.tennismate.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hackintosh.tennismate.InstanceData;
import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.service.MatchService;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtInfoPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtInfoView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CourtInfoActivity extends BaseAuthenticatedActivity<CourtInfoView, CourtInfoPresenter> implements CourtInfoView {

    @BindView(R.id.datePicker)
    DatePicker datePicker;

    @BindView(R.id.timePicker)
    TimePicker timePicker;

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
        Calendar instance = Calendar.getInstance();
        instance.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(), timePicker.getCurrentHour(), timePicker.getCurrentMinute());
        InstanceData.plannedDate = instance.getTime();

        MatchService matchService = new MatchService();

        matchService.createMatch(() -> presenter.navigator.openPartnerFinderActivity(), (msg) -> Toast.makeText(this, msg, Toast.LENGTH_LONG).show());
    }
}
