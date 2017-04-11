package com.nicky.practice.tij.type;

public class InstanceofVsEqual {
	private static void print(String s) {
		System.out.println(s);
	}

	static void test(Object x) {
		print("Testing x of type " + x.getClass());
		print("x instanceof Base " + (x instanceof Base));
		print("x instanceof Derived " + (x instanceof Derived));
		print("Base.isInstance(x) " + Base.class.isInstance(x));
		print("Derived.isInstance(x) " + Derived.class.isInstance(x));
		print("x.getClass() == Base.class " + (x.getClass() == Base.class));
		print("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		print("x.getClass().equals(Base.class)) " + (x.getClass().equals(Base.class)));
		print("x.getClass().equals(Derived.class)) " + (x.getClass().equals(Derived.class)));
	}

	// A isstanceof B, when A is derived from B, it is also true. but for .class == .class is false. 
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
}

class Base {
}

class Derived extends Base {
}
