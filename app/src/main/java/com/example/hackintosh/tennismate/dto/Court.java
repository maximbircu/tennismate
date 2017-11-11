package com.example.hackintosh.tennismate.dto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nicu on 11/12/17.
 */

public class Court {
    private int id;
    private String title;
    private String imageUrl;
    private List<Integer> terrains;

    public Court() {
    }

    public Court(int id, String title, String imageUrl, List<Integer> terrains) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.terrains = terrains;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Integer> getTerrains() {
        return Arrays.asList(new Integer[]{1,2,3});
    }
}
