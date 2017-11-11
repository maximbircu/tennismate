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
        setContentView(R.layout.activity_court_list);

        setPresenter();
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerViewAdapter(getDummyList());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.setContentLayout(R.layout.activity_court_list);
    }

    public void setPresenter() {
        super.setPresenter(new CourtListPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    public List<String> getDummyList() {
        List<String> dummyList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            dummyList.add("Court Number " + i);
        }

        return dummyList;
    }
}
