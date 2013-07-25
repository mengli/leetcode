Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

public class Solution {
    public boolean isScramble(String s1, String s2) {
    	int length1 = s1.length();
		int length2 = s2.length();
		if (length1 != length2)
			return false;

		if (length1 == 0 || s1.equals(s2))
			return true;

		char[] ca1 = s1.toCharArray();
		char[] ca2 = s2.toCharArray();
		Arrays.sort(ca1);
		Arrays.sort(ca2);
		if (!Arrays.equals(ca1, ca2))
			return false;

		int i = 1;
		while (i < length1) {
			String a1 = s1.substring(0, i);
			String b1 = s1.substring(i, length1);
			String a2 = s2.substring(0, i);
			String b2 = s2.substring(i, length2);
			if (a1.equals(b2) && b1.equals(a2)) return true;
			boolean r = isScramble(a1, a2) && isScramble(b1, b2);
			if (!r) {
				String c2 = s2.substring(0, length1 - i);
				String d2 = s2.substring(length1 - i);
				r = isScramble(a1, d2) && isScramble(b1, c2);
			}
			if (r) return true;
			i++;
		}
		return false;
	}
}