package com.example.hackintosh.tennismate.ui.activities;


import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hackintosh.tennismate.InstanceData;
import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.RandomPartnerFinderPresenter;
import com.example.hackintosh.tennismate.ui.view.RandomPartnerFinderView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PlanGameActivity extends BaseAuthenticatedActivity<RandomPartnerFinderView, RandomPartnerFinderPresenter> implements RandomPartnerFinderView {

    @BindView(R.id.headerText)
    TextView headerText;

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
        setActivityElementsStyle();
    }

    @OnClick(R.id.play_single)
    public void onSingleModeClick(){
        InstanceData.players = 1;
        presenter.navigator.openCourtListActivity();
    }

    @OnClick(R.id.play_double)
    public void onDoubleModeClick(){
        InstanceData.players = 3;
        presenter.navigator.openCourtListActivity();
    }

    public void setPresenter() {
        super.setPresenter(new RandomPartnerFinderPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    public void setActivityElementsStyle() {

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Latinotype - Isidora-Light.otf");
        headerText.setTypeface(typeface);
    }
}
