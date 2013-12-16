

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ret = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		generateParenthesis(n, 0, 0, 0, sb, ret);
		return ret;
	}

	public void generateParenthesis(int n, int s, int e, int l,
			StringBuilder sb, ArrayList<String> ret) {
		if (s == n && e == n) {
			ret.add(sb.toString());
		} else {
			if (l > 0 && e < n) {
				sb.append(')');
				generateParenthesis(n, s, e + 1, l - 1, sb, ret);
				sb.deleteCharAt(sb.length() - 1);
			}
			if (s < n) {
				sb.append('(');
				generateParenthesis(n, s + 1, e, l + 1, sb, ret);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}