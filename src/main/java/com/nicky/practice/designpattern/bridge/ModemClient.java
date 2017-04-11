package com.nicky.practice.designpattern.bridge;

import org.junit.Test;

import com.nicky.practice.designpattern.bridge.controller.DedModemController;
import com.nicky.practice.designpattern.bridge.controller.DialModemController;
import com.nicky.practice.designpattern.bridge.modem.DedicatedModem;
import com.nicky.practice.designpattern.bridge.modem.ErniesModem;
import com.nicky.practice.designpattern.bridge.modem.HayesModem;
import com.nicky.practice.designpattern.bridge.modem.Modem;
import com.nicky.practice.designpattern.bridge.modem.ModemImplementation;

public class ModemClient {
	@Test
	public void testDedUsers() {
		ModemImplementation modemImpl = new ErniesModem();
		DedicatedModem modem = new DedModemController(modemImpl);
		modem.send();
		modem.receive();
	}

	@Test
	public void testModemUser() {
		ModemImplementation modemImpl = new HayesModem();
		Modem modem = new DialModemController(modemImpl);
		modem.dial();
		modem.hangUp();
		modem.send();
		modem.receive();
	}
}
