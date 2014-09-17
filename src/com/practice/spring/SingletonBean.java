package com.practice.spring;

public class SingletonBean {
    private ProtoTypeBean prototypeBean;

    public ProtoTypeBean getPrototypeBean() {
        return prototypeBean;
    }

    public void setPrototypeBean(ProtoTypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
