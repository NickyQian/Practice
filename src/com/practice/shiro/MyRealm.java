package com.practice.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

	@Override
	public String getName() {
		return "MyFirstRealm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// To define that only support UsernamePasswordToken
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		if (!"Nick".equals(username)) {
			throw new UnknownAccountException(); // 如果用户名错误
		}

		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}

		return new SimpleAuthenticationInfo(username, password, getName());
	}
}
