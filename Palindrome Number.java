Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        int k = 1;
        int t = x;
        while ((t = t / 10) != 0) k *= 10;
        while (x >= 10) {
        	int d1 = x / k;
        	int d2 = x - x / 10 * 10;
        	if (d1 != d2) return false;
        	x = x / 10 - d1 * (k - 1);
        	k -= 2;
        }
        return true;
    }
}