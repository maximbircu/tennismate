package com.example.hackintosh.tennismate.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.ui.navigation.DrawerController;
import com.example.hackintosh.tennismate.ui.presenters.BasePresenter;
import com.example.hackintosh.tennismate.ui.view.BaseView;

/**
 * Created by maxim on 11/11/17.
 */

public abstract class BaseAuthenticatedActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity<V, P> {

    private static String TAG = BaseAuthenticatedActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_base_authenticated);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initNavigationController();
    }

    protected void initNavigationController() {
        DrawerController<BaseAuthenticatedActivity> drawerController = new DrawerController<>(this,
                R.layout.navigation,
                R.id.navigation_drawer_container);

        drawerController.setMenuItems(R.menu.menu_items);
        drawerController.addConsumerForMenuItem(R.id.court_list, presenter::openCourtList);
        drawerController.addConsumerForMenuItem(R.id.partner_finder, presenter::partnerFinder);
        drawerController.addConsumerForMenuItem(R.id.random_partner_finder, presenter::randomPartnerFinder);
        drawerController.addConsumerForMenuItem(R.id.logout, presenter::logout);
    }


    public void setContentLayout(int contentLayoutId) {
        ViewGroup contentContainer = (ViewGroup) this.findViewById(R.id.content_container);
        LayoutInflater layoutInflater = getLayoutInflater();
        layoutInflater.inflate(contentLayoutId, contentContainer, true);
    }
}
