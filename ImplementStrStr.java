

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 */

public class ImplementStrStr {
	public String strStr(String haystack, String needle) {
		int i = 0;
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 == 0 && len2 == 0)
			return "";
		for (; i < len1; i++) {
			int a = i;
			int b = 0;
			boolean match = true;
			while (b < len2) {
				if (a >= len1 || haystack.charAt(a) != needle.charAt(b)) {
					match = false;
					break;
				} else {
					a++;
					b++;
				}
			}
			if (match)
				return haystack.substring(i);
		}
		return null;
	}
}