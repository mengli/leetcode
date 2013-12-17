/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "a*") -> true
 * isMatch("aa", ".*") -> true
 * isMatch("ab", ".*") -> true
 * isMatch("aab", "c*a*b") -> true
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int i, String p, int j) {
		int ls = s.length();
		int lp = p.length();
		if (j == lp) {
			return i == ls;
		}
		if ((j < lp - 1 && p.charAt(j + 1) != '*') || j == lp - 1) {
			return (i < ls && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && isMatch(s, i + 1, p, j + 1);
		}
		while ((i < ls && s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.' && i < ls)) {
			if (isMatch(s, i, p, j + 2))
				return true;
			i++;
		}
		return isMatch(s, i, p, j + 2);
	}
}
