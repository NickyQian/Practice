package com.nicky.practice.math;

import java.text.DecimalFormat;

import org.junit.Assert;
import org.junit.Test;

public class DoublePrecision {
	private Integer precisionNum = 7;

	@Test
	public void testPrecision() {
		DecimalFormat decimalFormat = new DecimalFormat(createPrecision(precisionNum));
		double d = 123.12345678;
		d = Double.parseDouble(decimalFormat.format(d));
		Assert.assertEquals(123.1234568, d, 0);
	}

	private String createPrecision(int precision) {
		StringBuffer sb = new StringBuffer("#");
		for (int i = 1; i <= precision; i++) {
			if (i == 1)
				sb.append(".");
			sb.append("#");
		}
		return sb.toString();
	}
}
