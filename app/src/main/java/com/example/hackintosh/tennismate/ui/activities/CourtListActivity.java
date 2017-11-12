package com.example.hackintosh.tennismate.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hackintosh.tennismate.R;
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

        mAdapter = new RecyclerViewAdapter(getDummyList());
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setPresenter() {
        super.setPresenter(new CourtListPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    public JSONArray getDummyList() throws JSONException {
        JSONArray dummyData = new JSONArray();
        for(int i = 0; i < 100; i++) {
            JSONObject data  = new JSONObject();
            data.put("name", "Court Number" + i);
            List<String> courts = new ArrayList<>();
            for(int j = 0; j < 3; j++) {
                courts.add("Field " + j);
            }
            data.put("courts", courts);

            dummyData.put(data);
        }

        return dummyData;
    }
}
