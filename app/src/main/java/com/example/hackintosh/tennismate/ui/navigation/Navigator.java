
package com.example.hackintosh.tennismate.ui.navigation;

import android.app.Activity;
import android.content.Intent;

import com.example.hackintosh.tennismate.ui.activities.LoginActivity;
import com.example.hackintosh.tennismate.ui.activities.SignUpActivity;
import com.example.hackintosh.tennismate.ui.view.CourtInfoView;
import com.example.hackintosh.tennismate.ui.view.CourtListView;
import com.example.hackintosh.tennismate.ui.view.PartnerFinderView;
import com.example.hackintosh.tennismate.ui.view.RandomPartnerFinderView;

import javax.inject.Inject;

/**
 * Created by Maxim Bircu on 11/11/17.
 */

public class Navigator {
    private Activity activity;

    @Inject
    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public void openLoginActivity() {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }


    public void openCourtListActivity() {
        Intent intent = new Intent(activity, CourtListView.class);
        activity.startActivity(intent);
        activity.finish();
    }


    public void openCourtInfoActivity() {
        Intent intent = new Intent(activity, CourtInfoView.class);
        activity.startActivity(intent);
        activity.finish();
    }


    public void openPartnerFinderActivity() {
        Intent intent = new Intent(activity, PartnerFinderView.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void openRandomPartnerFinderActivity() {
        Intent intent = new Intent(activity, RandomPartnerFinderView.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void openSignUpActivity() {
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
