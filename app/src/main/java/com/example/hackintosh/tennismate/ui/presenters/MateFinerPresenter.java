
package com.example.hackintosh.tennismate.ui.presenters;


import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.view.MateFinderView;

/**
 * Created by Maxim Bircu on 4/4/17.
 */

public class MateFinerPresenter extends BasePresenter<MateFinderView> {

    public MateFinerPresenter(Navigator navigator) {
        super(navigator);
        navigator.openLoginActivity();
    }
}
