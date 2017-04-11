package com.nicky.practice.designpattern.bridge.modem;

public class HayesModem implements ModemImplementation {

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
