

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] mat = new boolean[s1.length() + 1][s2.length() + 1];
		mat[0][0] = true;
		for (int i = 1; i <= s1.length(); ++i)
			mat[i][0] = mat[i - 1][0] && (s3.charAt(i - 1) == s1.charAt(i - 1));
		for (int i = 1; i <= s2.length(); ++i)
			mat[0][i] = mat[0][i - 1] && (s3.charAt(i - 1) == s2.charAt(i - 1));
		for (int i = 1; i <= s1.length(); ++i)
			for (int j = 1; j <= s2.length(); ++j)
				mat[i][j] = (mat[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i
						+ j - 1))
						|| (mat[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i
								+ j - 1));
		return mat[s1.length()][s2.length()];
	}
}