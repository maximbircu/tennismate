package com.example.hackintosh.tennismate.ui.presenters;

import com.example.hackintosh.tennismate.ui.navigation.Navigator;

/**
 * Created by maxim on 11/11/17.
 */

public class BasePresenter<V> {
    private V view;
    protected final Navigator navigator;

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
}
