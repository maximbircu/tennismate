
package com.example.hackintosh.tennismate.ui.presenters;


import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.BasePresenter;
import com.example.hackintosh.tennismate.ui.view.SplashView;

/**
 * Created by Maxim Bircu on 4/4/17.
 */

public class SplashPresenter extends BasePresenter<SplashView> {

    public SplashPresenter(Navigator navigator) {
        super(navigator);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        navigator.openLoginActivity();
    }
}
