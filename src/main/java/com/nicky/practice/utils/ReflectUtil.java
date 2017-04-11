package com.nicky.practice.utils;

public class ReflectUtil {
	public static void setField(Object object, String fieldName, Object value) {
		try {
			java.lang.reflect.Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void setSuperField(Object object, String fieldName, Object value) {
		try {
			java.lang.reflect.Field field = object.getClass().getSuperclass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
