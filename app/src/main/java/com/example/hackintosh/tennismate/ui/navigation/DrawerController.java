package com.example.hackintosh.tennismate.ui.navigation;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.portability.Consumer;
import com.example.hackintosh.tennismate.ui.activities.BaseActivity;

import java.util.Dictionary;
import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maxim on 11/11/17.
 */

public class DrawerController<A extends BaseActivity> {
    private A activity;
    private ViewGroup navigationDrawerContainer;
    private Dictionary<Integer, Consumer<MenuItem>> menuItemSelectedConsumers;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navigationView;


    public DrawerController(A activity, int navigationLayoutId, int navigationDrawerContainerId) {
        this.activity = activity;
        menuItemSelectedConsumers = new Hashtable<>();
        navigationDrawerContainer = (ViewGroup) activity.findViewById(navigationDrawerContainerId);
        inflateContents(activity, navigationLayoutId);
    }

    private void inflateContents(A activity, int navigationLayoutId) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        layoutInflater.inflate(navigationLayoutId, navigationDrawerContainer, true);
        ButterKnife.bind(this, navigationDrawerContainer);
        InitNavigationView();
    }

    private void InitNavigationView() {
        activity.setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    public void setMenuItems(int menuId) {
        navigationView.getMenu().clear();
        navigationView.inflateMenu(menuId);
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Consumer<MenuItem> consumer = menuItemSelectedConsumers.get(item.getItemId());
        if (consumer != null) {
            consumer.accept(item);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addConsumerForMenuItem(Integer menuItemId, Consumer<MenuItem> consumer) {
        if (menuItemSelectedConsumers.get(menuItemId) == null) {
            menuItemSelectedConsumers.put(menuItemId, consumer);
        }
    }
}
