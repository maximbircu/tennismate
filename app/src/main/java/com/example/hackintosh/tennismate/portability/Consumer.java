package com.example.hackintosh.tennismate.portability;

/**
 * Created by maxim on 11/11/17.
 */

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
