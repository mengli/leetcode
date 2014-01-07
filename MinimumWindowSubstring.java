

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: 
 * 
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int[] hasFound = new int[256];
		int[] needFound = new int[256];
		int diffCount = T.length();
		int length = S.length();
		String window = "";
		int size = Integer.MAX_VALUE;
		if (length == 0 || diffCount == 0)
			return window;
		for (int l = 0; l < diffCount; l++) {
			needFound[T.charAt(l)]++;
		}
		int i = 0, j = 0;
		while (j < length) {
			char c = S.charAt(j);
			if (needFound[c] > 0 && ++hasFound[c] <= needFound[c]) {
				diffCount--;
			}
			if (diffCount == 0) {
				while (i <= j) {
					char h = S.charAt(i);
					i++;
					if (needFound[h] > 0 && --hasFound[h] < needFound[h]) {
						if (j - i + 1 < size) {
							size = j - i + 1;
							window = S.substring(i - 1, j + 1);
						}
						diffCount++;
						break;
					}
				}
			}
			j++;
		}
		return window;
	}
}