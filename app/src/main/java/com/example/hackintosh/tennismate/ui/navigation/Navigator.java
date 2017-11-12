
package com.example.hackintosh.tennismate.ui.navigation;

import android.app.Activity;
import android.content.Intent;

import com.example.hackintosh.tennismate.ui.activities.CourtInfoActivity;
import com.example.hackintosh.tennismate.ui.activities.CourtListActivity;
import com.example.hackintosh.tennismate.ui.activities.LoginActivity;
import com.example.hackintosh.tennismate.ui.activities.PartnerFinderActivity;
import com.example.hackintosh.tennismate.ui.activities.PlanGameActivity;
import com.example.hackintosh.tennismate.ui.activities.SignUpActivity;

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
        Intent intent = new Intent(activity, CourtListActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }


    public void openCourtInfoActivity() {
        Intent intent = new Intent(activity, CourtInfoActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }


    public void openPartnerFinderActivity() {
        Intent intent = new Intent(activity, PartnerFinderActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void openPlanGame() {
        Intent intent = new Intent(activity, PlanGameActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void openSignUpActivity() {
        Intent intent = new Intent(activity, SignUpActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void logout(){

    }
}
