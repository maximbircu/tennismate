package com.example.hackintosh.tennismate.ui.navigation;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.portability.Consumer;
import com.example.hackintosh.tennismate.service.UserService;
import com.example.hackintosh.tennismate.ui.activities.BaseActivity;
import com.example.hackintosh.tennismate.utils.CircleTransform;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Dictionary;
import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

/**
 * Created by maxim on 11/11/17.
 */

public class DrawerController<A extends BaseActivity> {
    private A activity;
    private ViewGroup navigationDrawerContainer;
    private Dictionary<Integer, Consumer<MenuItem>> menuItemSelectedConsumers;

    private String toolbarTitle;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    private ImageView userIcon;

    private TextView fullName;

    private TextView email;

    @BindView(R.id.nav_view)
    NavigationView navigationView;


    public DrawerController(A activity, int navigationLayoutId, int navigationDrawerContainerId, String toolbarTitle) {
        this.activity = activity;
        this.toolbarTitle = toolbarTitle;
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
        toolbar.setTitle(toolbarTitle);
        activity.setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);


        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        View headerView = navigationView.getHeaderView(0);

        userIcon = (ImageView)headerView.findViewById(R.id.imageView);
        fullName = (TextView) headerView.findViewById(R.id.fullName);
        email = (TextView) headerView.findViewById(R.id.email);


        Picasso.with(activity)
                .load(currentUser.getPhotoUrl())
                .transform(new CircleTransform())
                .into(userIcon);

        fullName.setText(currentUser.getDisplayName());
        email.setText(currentUser.getEmail());
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
