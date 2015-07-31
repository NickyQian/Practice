package com.practice.designpattern.bridge.controller;

import com.practice.designpattern.bridge.modem.ModemImplementation;

public class DedModemController extends ModemConnectionController {

	public DedModemController(ModemImplementation modemImpl) {
		super(modemImpl);
	}

	@Override
	public void dial() {
		System.out.println("[Useless] Don't need to implement");
	}

	@Override
	public void hangUp() {
		System.out.println("[Useless] Don't need to implement");
	}
}
