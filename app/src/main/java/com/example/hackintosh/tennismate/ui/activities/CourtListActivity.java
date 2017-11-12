package com.example.hackintosh.tennismate.ui.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.dto.Court;
import com.example.hackintosh.tennismate.portability.Consumer;
import com.example.hackintosh.tennismate.service.CourtsServices;
import com.example.hackintosh.tennismate.ui.adapters.RecyclerViewAdapter;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.CourtListPresenter;
import com.example.hackintosh.tennismate.ui.view.CourtListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maxim on 11/11/17.
 */


public class CourtListActivity extends BaseAuthenticatedActivity<CourtListView, CourtListPresenter> implements CourtListView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter();
        this.toolbarTitle = "Courts List";
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_court_list);
        try {
            setupRecycler();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        createNotification();
    }

    private void setupRecycler() throws JSONException {
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        populateCourtList();
    }

    public void setPresenter() {
        super.setPresenter(new CourtListPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    public void populateCourtList() {
        CourtsServices courtsServices = new CourtsServices();
        courtsServices.getCourts((data) -> {
            mAdapter = new RecyclerViewAdapter(data);
            mRecyclerView.setAdapter(mAdapter);

        }, (error) -> Log.d("dsd", error));
    }

    public void createNotification() {

        Intent intent = new Intent(this, PlanGameActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);


        Notification noti = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject").setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setContentIntent(pIntent)
                .addAction(R.drawable.common_google_signin_btn_icon_light, "Accept", pIntent)
                .addAction(R.drawable.common_google_signin_btn_icon_dark_normal_background, "Decline", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }
}
