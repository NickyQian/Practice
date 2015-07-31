package com.practice.designpattern.bridge.controller;

import com.practice.designpattern.bridge.modem.ModemImplementation;

public class DialModemController extends ModemConnectionController {

	public DialModemController(ModemImplementation modemImpl) {
		super(modemImpl);
	}

	@Override
	public void dial() {
		modemImpl.dial();
	}

	@Override
	public void hangUp() {
		modemImpl.hangUp();
	}

}
