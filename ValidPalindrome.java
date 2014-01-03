
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
		while (i < j) {
			if (!isAlphabet(s.charAt(i))) {
				i++;
			} else if(!isAlphabet(s.charAt(j))) {
				j--;
			} else if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}
	
	private boolean isAlphabet(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}
}