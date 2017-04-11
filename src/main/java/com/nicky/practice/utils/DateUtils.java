package com.nicky.practice.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * This is for JDK 8
 * 
 */
public class DateUtils {

	public static final String uuuuMM = "uuuuMM";

	public static YearMonth getAdjusterMonth(String date, long adjuster) {
		YearMonth localDate = YearMonth.parse(date, DateTimeFormatter.ofPattern(uuuuMM));
		return localDate.plusMonths(adjuster);
	}

	public static String toUUUUMM(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern(uuuuMM));
	}
	
	public static String toUUUUMM(YearMonth yearAndMonth) {
		return yearAndMonth.format(DateTimeFormatter.ofPattern(uuuuMM));
	}

	/**
	 * 201401 ---> 201312
	 * 
	 * @param uuuuMM
	 * @return
	 */
	public static String getBeforeMonth(String date) {
		return toUUUUMM(getAdjusterMonth(date, -1));
	}

	/**
	 * 201312 ---> 201401
	 * 
	 * @param uuuuMM
	 * @return
	 */
	public static String getAfterMonth(String date) {
		return toUUUUMM(getAdjusterMonth(date, 1));
	}

}
