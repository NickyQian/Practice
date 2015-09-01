package com.practice.tij.io.filewalker;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
	private static final String NEW_LIN = "\n ";

	public static String pformat(Collection<?> c) {
		if (c.size() == 0)
			return "[]";
		StringBuilder result = new StringBuilder("[");
		c.stream().forEach(elem -> {
			if (c.size() != 1)
				result.append(NEW_LIN);
			result.append(elem);
		});
		if (c.size() != 1) {
			result.append("\n");
		}
		result.append("]");
		return result.toString();
	}

	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}

	public static void pprint(Object[] c) {
		System.out.println(pformat(Arrays.asList(c)));
	}
}
