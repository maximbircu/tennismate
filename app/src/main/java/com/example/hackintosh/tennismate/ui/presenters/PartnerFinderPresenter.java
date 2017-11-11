
package com.example.hackintosh.tennismate.ui.presenters;


import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.view.PartnerFinderView;
import com.example.hackintosh.tennismate.ui.view.RandomPartnerFinderView;

/**
 * Created by Maxim Bircu on 4/4/17.
 */

public class PartnerFinderPresenter extends BasePresenter<PartnerFinderView> {

    public PartnerFinderPresenter(Navigator navigator) {
        super(navigator);
        navigator.openLoginActivity();
    }
}
