package com.example.hackintosh.tennismate.ui.activities;


import android.os.Bundle;
import android.view.View;

import com.example.hackintosh.tennismate.InstanceData;
import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.RandomPartnerFinderPresenter;
import com.example.hackintosh.tennismate.ui.view.RandomPartnerFinderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PlanGameActivity extends BaseAuthenticatedActivity<RandomPartnerFinderView, RandomPartnerFinderPresenter> implements RandomPartnerFinderView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
        this.toolbarTitle = "Plan a game";
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_plan_game);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.single_mode)
    public void onSingleModeClick(){
        InstanceData.players = 1;
        presenter.navigator.openCourtListActivity();
    }

    @OnClick(R.id.double_mode)
    public void onDoubleModeClick(){
        InstanceData.players = 3;
        presenter.navigator.openCourtListActivity();
    }

    public void setPresenter() {
        super.setPresenter(new RandomPartnerFinderPresenter(new Navigator(this)));
        presenter.bind(this);
    }
}
