Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1.length() + s2.length() != s3.length()) return false;
	boolean[][] mat = new boolean[s1.length() + 1][s2.length() + 1];
	mat[0][0] = true;
	for (int i = 1; i <= s1.length(); ++i)
            mat[i][0] = mat[i - 1][0] && (s3.charAt(i - 1) == s1.charAt(i - 1));
	for (int i = 1; i <= s2.length(); ++i)
	    mat[0][i] = mat[0][i - 1] && (s3.charAt(i - 1) == s2.charAt(i - 1));
	for (int i = 1; i <= s1.length(); ++i)
	    for (int j = 1; j <= s2.length(); ++j)
		mat[i][j] = (mat[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (mat[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
	return mat[s1.length()][s2.length()];
    }
}


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	return search(s1, s2, s3, 0, 0, 0);
    }

    private boolean search(String s1, String s2, String s3, int i1, int i2, int i3) {
	int len1 = s1.length(), len2 = s2.length();
	if (i1 < len1 && i2 < len2) {
	    boolean result = false;
	    if (s1.charAt(i1) == s3.charAt(i3)) {
		i1++;
		i3++;
		result = search(s1, s2, s3, i1, i2, i3);
		if (result) {
		    return true;
		} else {
		    i1--;
		    i3--;
		}
	    }
			
	    if (s2.charAt(i2) == s3.charAt(i3)) {
	        i2++;
		i3++;
		result = search(s1, s2, s3, i1, i2, i3);
		return result;
	    }
			
	    return false;
	}
	if (i1 < len1) {
	    return s1.substring(i1).compareTo(s3.substring(i3)) == 0;
	}
	return s2.substring(i2).compareTo(s3.substring(i3)) == 0;
    }
}