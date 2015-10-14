package com.practice.shiro;

import static org.junit.Assert.assertEquals;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroLearning {

	// private static Logger log = Logger.getLogger(ShiroLearning.class);

	@Test
	public void testAuthenticationWithRealms() {
		testAuthentication("classpath:config/shiro.ini");
	}

	@Test
	public void testAuthenticationWithDefinedUsers() {
		testAuthentication("classpath:config/shiro-realm.ini");
	}

	private void testAuthentication(String filePath) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(filePath);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("Nick", "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {

		}
		assertEquals(true, subject.isAuthenticated());

		subject.logout();
	}
}
