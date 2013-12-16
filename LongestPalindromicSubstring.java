

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 */

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int length = s.length();
		String result = "";
		for (int i = 0; i < length; i++) {
			String ps = getPalindrome(s, i, i);
			if (ps.length() > result.length()) {
				result = ps;
			}
			ps = getPalindrome(s, i, i + 1);
			if (ps.length() > result.length()) {
				result = ps;
			}
		}
		return result;
	}

	private String getPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}
}