package com.practice.convert;

public class StringToInt {

	public static int convert(String input) {
		int result = 0;
		double doubleInput;
		// exact space, characters in the string.
		String intputTrim = input.replaceAll("[a-z|A-Z|\\s]","");

		// if input is empty, retrun 0.
		if (intputTrim.equals("")) {
			System.out.println("the string is empty.");
			return 0;
		}

		// if input contains '.', judge whether this string can convert to
		// double.
		if (intputTrim.contains(".")) {
			try {
				doubleInput = Double.parseDouble(intputTrim);
				return (int) doubleInput;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("your input has illegal characters.");
			}
		}

		try {
			double max = Double.parseDouble(intputTrim);
			// if the string to int is a large number which is out the bound of
			// int.
			if (max > Integer.MAX_VALUE) {
				System.out.println("your input is too large.");
				return 0;
			}
			// if the string to int is a small number which is out the bound of
			// int.
			if (max < Integer.MIN_VALUE) {
				System.out.println("your input is too small.");
				return 0;
			}
			result = Integer.parseInt(intputTrim);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("your input has illegal characters.");
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "  12  .Z3   ";
		int output = StringToInt.convert(input);
		System.out.println(output);
	}

}
