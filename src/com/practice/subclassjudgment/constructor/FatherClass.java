package com.practice.subclassjudgment.constructor;

public class FatherClass {
	@SuppressWarnings("unused")
	private FatherClass() {
		System.out.println("Error");
		throw new RuntimeException();
	}
	
	public FatherClass(String name) {
		
	}
}
