package com.kata.reversepolish;

import java.util.Stack;
import java.util.stream.Stream;

public class RPNCalculatorImpl implements RPNCalculator {

	private Stack<Integer> stack = new Stack<Integer>();

	private InfixToPostFix infixToPostFix = new InfixToPostFix() {

		@Override
		public String convertToPostFix(String infix) {

			Stream.of(infix.split(" ")).forEach(this::infixToPostFix);

			while (!operationStack.isEmpty()) {
				result.append(operationStack.pop()).append(" ");
			}
			return result.toString();
		}

		private Stack<String> operationStack = new Stack<String>();
		private StringBuilder result = new StringBuilder();

		private void infixToPostFix(String inputStr) {
			if ("+-*/()".contains(inputStr)) {
				switch (inputStr) {
				case "(":
					operationStack.push(inputStr);
					break;
				case ")":
					String operation = operationStack.pop();
					while (!"(".equals(operation)) {
						result.append(operation).append(" ");
						operation = operationStack.pop();
					}
					break;
				default:
					if (!operationStack.isEmpty()) {
						for (String s1Top = operationStack.peek(); !operationStack.isEmpty()
								&& needsPop(inputStr, s1Top); s1Top = operationStack.peek()) {
							result.append(operationStack.pop()).append(" ");
							if (operationStack.isEmpty()) {
								break;
							}
						}
						operationStack.push(inputStr);
					} else {
						operationStack.push(inputStr);
					}
				}
			} else {
				result.append(inputStr).append(" ");
			}

		}
		// when to pop up from operation stack
		public boolean needsPop(String a, String b) {
			if (b.equals("(")) {
				return false;
			}
			if ("*/".contains(b)) {
				return true;
			}
			return false;
		};

	};

	@Override
	public int calculate(String input) {
		String rnp = infixToPostFix.convertToPostFix(input);
		Stream.of(rnp.split(" ")).forEach(this::rpnCalculate);
		return stack.pop();
	}

	private void rpnCalculate(String inputStr) {
		if ("+-*/".contains(inputStr)) {
			int b = stack.pop();
			int a = stack.pop();
			stack.push(calculateFunction.calculate(a, b, inputStr));
		} else {
			stack.push(Integer.valueOf(inputStr));
		}
	}

	private static final CalculateFunction calculateFunction = (a, b, operation) -> {
		int result = 0;
		switch (operation) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		default:
			throw new IllegalArgumentException("Wrong input operation:" + operation);
		}
		return result;
	};

}
