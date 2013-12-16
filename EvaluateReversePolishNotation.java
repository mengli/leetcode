

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();
		int size = tokens.length;
		for (int i = 0; i < size; i++) {
			if (isDigital(tokens[i])) {
				st.push(Integer.parseInt(tokens[i]));
			} else {
				st.push(calc(st.pop(), st.pop(), tokens[i]));
			}
		}
		return st.pop();
	}

	private Integer calc(Integer num2, Integer num1, String op) {
		switch (op.charAt(0)) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		default:
			return 0;
		}
	}

	private boolean isDigital(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
