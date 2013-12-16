

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */

public class CountandSay {
	public String countAndSay(int n) {
		StringBuilder s1 = new StringBuilder("1");
		StringBuilder s2 = new StringBuilder();
		for (int i = 1; i < n; i++) {
			int j = 0;
			int len = s1.length();
			while (j < len) {
				int count = 1;
				char c = s1.charAt(j);
				while (j < len - 1 && s1.charAt(j + 1) == s1.charAt(j)) {
					count++;
					j++;
				}
				s2.append(count + "");
				s2.append(c);
				if (j == len - 1) {
					break;
				}
				j++;
			}
			s1 = s2;
			s2 = new StringBuilder();
		}
		return s1.toString();
	}
}