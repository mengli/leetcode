Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0)
			return true;
		else {
			int begin = 0;
			int end = s.length() - 1;
			while (true) {
				while (end > 0 && !((s.charAt(end) >= 'a' && s.charAt(end) <= 'z')
						|| (s.charAt(end) >= 'A' && s.charAt(end) <= 'Z') || ((s.charAt(end) >= '0' && s.charAt(end) <= '9')))) {
					end--;
				}
				while (begin < s.length() && !((s.charAt(begin) >= 'a' && s.charAt(begin) <= 'z')
						|| (s.charAt(begin) >= 'A' && s.charAt(begin) <= 'Z' || ((s.charAt(begin) >= '0' && s.charAt(begin) <= '9'))))) {
					begin++;
				}
				if (end - begin > 0) {
					if (s.charAt(end) != s.charAt(begin)) {
						return false;
					}
					else {
						end--;
						begin++;
					}
				} else {
					return true;
				}
			}
		}
	}
}