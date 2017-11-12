package com.example.hackintosh.tennismate.ui.activities;

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
}
