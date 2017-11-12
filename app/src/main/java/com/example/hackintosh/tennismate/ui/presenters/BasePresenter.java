package com.example.hackintosh.tennismate.ui.presenters;

import android.view.MenuItem;

import com.example.hackintosh.tennismate.ui.navigation.Navigator;

/**
 * Created by maxim on 11/11/17.
 */

public class BasePresenter<V> {
    private V view;
    public final Navigator navigator;

    protected BasePresenter(Navigator navigator) {
        this.navigator = navigator;
    }

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
    }

    public V getView() {
        return view;
    }

    public void bind(V view) {
        this.view = view;
    }


    public void openCourtList(MenuItem menuItem) {
        navigator.openCourtListActivity();
    }

    public void partnerFinder(MenuItem menuItem) {
        navigator.openPartnerFinderActivity();
    }

    public void randomPartnerFinder(MenuItem menuItem) {
        navigator.openPlanGame();
    }

    public void logout(MenuItem menuItem) {
        navigator.logout();
    }
}
