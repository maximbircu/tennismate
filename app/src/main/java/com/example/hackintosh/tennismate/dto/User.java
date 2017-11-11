package com.example.hackintosh.tennismate.dto;

import java.io.Serializable;

/**
 * Created by lschidu on 11/11/17.
 */

public class User implements Serializable {
    private String uuid;
    private String email;
    private Short age;
    private String fullName;
    private LevelEnum level;
    private String imageUrl;

    public User() {
    }

    public User(String email, Short age, String fullName, LevelEnum level, String imageUrl) {
        this.email = email;
        this.age = age;
        this.fullName = fullName;
        this.level = level;
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

