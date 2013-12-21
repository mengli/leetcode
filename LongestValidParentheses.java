import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int length = s.length();
		if (length == 0)
			return 0;
		int left = 0;
		Stack<Integer> indexs = new Stack<Integer>();
		boolean[] record = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == '(') {
				left++;
				indexs.push(i);
			} else if (left > 0) {
				int idx = indexs.pop();
				record[idx] = true;
				record[i] = true;
				left--;
			}
		}
		int ret = 0;
		int current = 0;
		for (int k = 0; k < length; k++) {
			if (record[k]) {
				current++;
			} else {
				ret = current > ret ? current : ret;
				current = 0;
			}
		}
		return ret > current ? ret : current;
	}
}