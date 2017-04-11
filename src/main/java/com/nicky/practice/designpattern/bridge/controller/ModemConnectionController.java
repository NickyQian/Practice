package com.nicky.practice.designpattern.bridge.controller;

import com.nicky.practice.designpattern.bridge.modem.DedicatedModem;
import com.nicky.practice.designpattern.bridge.modem.Modem;
import com.nicky.practice.designpattern.bridge.modem.ModemImplementation;

public abstract class ModemConnectionController implements Modem, DedicatedModem {

	protected ModemImplementation modemImpl;
	
	public ModemConnectionController(ModemImplementation modemImpl) {
		this.modemImpl = modemImpl;
	}
	
	public void dailImpl() {
		modemImpl.dial();
	}
	
	@Override
	public abstract void dial();

	@Override
	public abstract void hangUp();

	@Override
	public void send() {
		modemImpl.send();
	}

	@Override
	public void receive() {
		modemImpl.receive();
	}

}
