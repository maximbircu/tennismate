package com.example.hackintosh.tennismate.ui.presenters;

import android.util.Log;

import com.example.hackintosh.tennismate.dto.User;
import com.example.hackintosh.tennismate.service.FirebaseHelper;
import com.example.hackintosh.tennismate.service.UserService;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.view.BaseView;
import com.example.hackintosh.tennismate.ui.view.SingnUpView;

/**
 * Created by maxim on 11/11/17.
 */

public class SignUpPresenter extends BasePresenter<SingnUpView> {
    public SignUpPresenter(Navigator navigator) {
        super(navigator);
    }

    public void registerUser(User user) {
        UserService userService = new UserService();
        userService.signUp(user, () -> {
            this.getView().onPostSuccess();
        }, s -> {

        });
    }
}
