

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		int i = 0, j = 0;
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (j < s.length()) {
			Integer c = new Integer(s.charAt(j));
			if (!map.containsKey(c)) {
				map.put(c, j);
			} else {
				int length = j - i;
				if (result < length) {
					result = length;
				}
				Integer index = map.get(c);
				i = Math.max(i, index + 1);
				map.put(c, j);
			}
			j++;
		}

		if (result < j - i)
			return j - i;
		else
			return result;
	}
}