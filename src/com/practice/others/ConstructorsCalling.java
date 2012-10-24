package com.practice.others;

public class ConstructorsCalling extends Base{

	public ConstructorsCalling() {
		System.out.println("This is ConstructorsCalling Class's constructor");
	}
	
	public ConstructorsCalling(int i) { // the super should be written in first line.
		super(1);						// if there's no super, it will call the default super();
		System.out.println("This is ConstructorsCalling Class's constructor with int i : " + i);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructorsCalling s = new ConstructorsCalling(1);
	}
}

class Base {
	public Base() {
		System.out.println("This is Base Class's constructor");
	}
	
	public Base(int i) {
		System.out.println("This is Base Class's constructor with int i : " + i);
	}
}
