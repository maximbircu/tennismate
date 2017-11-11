package com.example.hackintosh.tennismate.service;

import com.example.hackintosh.tennismate.dto.Court;
import com.example.hackintosh.tennismate.portability.Consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by nicu on 11/11/17.
 */

public class CourtsServices {
    private static final String node = "/courts";

    public void getCourts(Consumer<List<Court>> onComplete, Consumer<String> onError){
        FirebaseHelper.getAllValues(node, Court.class, onComplete,onError);
    }
}
