package com.practice.designpattern.bridge;

import org.junit.Test;

import com.practice.designpattern.bridge.controller.DedModemController;
import com.practice.designpattern.bridge.controller.DialModemController;
import com.practice.designpattern.bridge.modem.DedicatedModem;
import com.practice.designpattern.bridge.modem.ErniesModem;
import com.practice.designpattern.bridge.modem.HayesModem;
import com.practice.designpattern.bridge.modem.Modem;
import com.practice.designpattern.bridge.modem.ModemImplementation;

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
