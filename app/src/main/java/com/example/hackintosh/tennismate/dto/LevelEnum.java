package com.example.hackintosh.tennismate.dto;

/**
 * Created by lschidu on 11/11/17.
 */

public enum  LevelEnum {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private final String level;

    LevelEnum(String level) {
        this.level = level;
    }

    String getLevel() {
        return level;
    }
}
