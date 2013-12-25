
/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note:
 * 
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toUpperCase();
		int i = 0, j = s.length() - 1;
		while (true) {
			while (i < s.length()
					&& !(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					&& !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				i++;
			while (j >= 0 && !(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')
					&& !(s.charAt(j) >= '0' && s.charAt(j) <= '9'))
				j--;
			if (i >= j) {
				return true;
			} else if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
	}
}