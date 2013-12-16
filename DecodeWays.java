

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */

public class DecodeWays {
	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		int[] c = new int[s.length() + 1];
		c[0] = 1;
		if (s.charAt(0) != '0')
			c[1] = c[0];
		else
			c[1] = 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '0') {
				c[i] = 0;
			} else {
				c[i] = c[i - 1];
			}
			if (s.charAt(i - 2) == '1'
					|| (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				c[i] += c[i - 2];
			}
		}
		return c[s.length()];
	}
}