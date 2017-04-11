package com.nicky.practice.spring;

public class SingletonBean {
    public int value;
    private ProtoTypeBean prototypeBean;

    public ProtoTypeBean getPrototypeBean() {
        return prototypeBean;
    }

    public void setPrototypeBean(ProtoTypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
