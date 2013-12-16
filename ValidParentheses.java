

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParentheses {
	public boolean isValid(String s) {
		int len = s.length();
		if (len == 0)
			return true;
		Stack<Character> st = new Stack<Character>();
		st.add(s.charAt(0));
		int i = 1;
		while (i < len) {
			switch (s.charAt(i)) {
			case '(':
				st.add('(');
				break;
			case ')':
				if (!st.empty() && st.peek() == '(') {
					st.pop();
				} else {
					return false;
				}
				break;
			case '{':
				st.add('{');
				break;
			case '}':
				if (!st.empty() && st.peek() == '{') {
					st.pop();
				} else {
					return false;
				}
				break;
			case '[':
				st.add('[');
				break;
			case ']':
				if (!st.empty() && st.peek() == '[') {
					st.pop();
				} else {
					return false;
				}
				break;
			}
			i++;
		}
		return st.empty();
	}
}