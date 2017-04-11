package com.nicky.practice.reflect;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class AccessibleObjectTest {

	@Test
	public void testCallPrivateMethod1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<ReflectTestClazz> clz = ReflectTestClazz.class;
		Constructor<ReflectTestClazz> constructor = clz.getConstructor(String.class);
		ReflectTestClazz instance = constructor.newInstance("OK");
		Method method = clz.getDeclaredMethod("privateMethod", String.class);
		method.setAccessible(true); // this is import
		String param = "test";
		Object resultCalledFromPrivateMethod = method.invoke(instance, param);
		assertEquals("test", resultCalledFromPrivateMethod);

		// public method does not need to be set accessible as true.
		Method publicMethod = clz.getDeclaredMethod("publicMethod");
		assertEquals("OK", publicMethod.invoke(instance));
	}

	@Test(expected = IllegalAccessException.class)
	public void testCallPrivateMethod2() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<ReflectTestClazz> clz = ReflectTestClazz.class;
		ReflectTestClazz instance = new ReflectTestClazz("OK");
		Method method = clz.getDeclaredMethod("privateMethod", String.class);
		String param = "test";
		method.invoke(instance, param); // private method can't be invoked.
	}
}
