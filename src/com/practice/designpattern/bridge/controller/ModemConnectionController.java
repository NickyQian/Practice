package com.practice.designpattern.bridge.controller;

import com.practice.designpattern.bridge.modem.DedicatedModem;
import com.practice.designpattern.bridge.modem.Modem;
import com.practice.designpattern.bridge.modem.ModemImplementation;

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
