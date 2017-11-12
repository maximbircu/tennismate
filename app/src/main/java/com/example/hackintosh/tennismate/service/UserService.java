package com.example.hackintosh.tennismate.service;

import com.example.hackintosh.tennismate.dto.User;
import com.example.hackintosh.tennismate.portability.Consumer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

/**
 * Created by nicu on 11/11/17.
 */

public class UserService {
    private static final String userNode = "/user";

    public void signUp(User user, Runnable onSuccess, Consumer<String> onError){
        String node = getNodeForCurrentUser();
        FirebaseHelper.setValue(node,user, onSuccess, onError);
    }

    public void getUserDetails(Consumer<User> consumer, Consumer<String> onError){
        FirebaseHelper.getValue(getNodeForCurrentUser(),User.class,consumer, onError);
    }


    public void getUsers(Consumer<List<User>> consumer, Consumer<String> onError){
        FirebaseHelper.getAllValues(userNode,User.class,consumer, onError);
    }

    public FirebaseUser getCurrentUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    private String getNodeForCurrentUser() {
        String uid = getCurrentUser().getUid();

        return String.format("%s/%s", userNode, uid);
    }

}
