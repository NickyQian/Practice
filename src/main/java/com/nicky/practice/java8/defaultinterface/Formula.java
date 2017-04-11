package com.nicky.practice.java8.defaultinterface;

public interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
