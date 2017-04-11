package com.nicky.practice.reflect;

public class ReflectTestClazz {
	private String privateStr;
	
	public ReflectTestClazz(String privateStr) {
		this.privateStr = privateStr;
	}
	
	@SuppressWarnings("unused")
	private String privateMethod(String name) {
		return name;
	}
	
	public String publicMethod() {
		return privateStr;
	}
}
