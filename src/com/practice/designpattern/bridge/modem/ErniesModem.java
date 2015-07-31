package com.practice.designpattern.bridge.modem;

public class ErniesModem implements ModemImplementation {

	@Override
	public void dial() {
		getMethodName();
	}

	@Override
	public void hangUp() {
		getMethodName();
	}

	@Override
	public void send() {
		getMethodName();
	}

	@Override
	public void receive() {
		getMethodName();
	}

}
