

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return the minimum cuts needed for a palindrome partitioning of s. 
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * D[i] = min(1 + D[j + 1], D[i]) i<=j<n s[i, j] is palindrome
 */

public class PalindromePartitioningII {
	public int minCut(String s) {
		int length = s.length();
		int[] dp = new int[length + 1];
		boolean[][] parlin = new boolean[length][length];

		for (int i = length; i >= 0; i--) {
			dp[i] = length - i;
		}

		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || parlin[i + 1][j - 1])) {
					parlin[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}

		return dp[0] - 1;
	}
}