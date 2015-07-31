package com.practice.designpattern.bridge.modem;

public interface ModemImplementation {
	public void dial();

	public void hangUp();

	public void send();

	public void receive();

	default void getMethodName() {
		System.out.println(Thread.currentThread().getStackTrace()[2].getClassName() +": "+Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}
