package com.nicky.practice.spring;

public class ProtoTypeBean {
    private ThreadLocal<Integer> value = new ThreadLocal<Integer>();
    public String valueStr;
    public void increase() {
        if (null == value.get())
            value.set(1);
        Integer h = value.get();
        value.set(++h);
    }

    public void reset() {
        value.remove();
    }

    public int getValue() {
        return value.get();
    }
}
