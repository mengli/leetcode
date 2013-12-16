

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if (A.length == 0)
			return 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] - 1 < A.length && A[i] - 1 != i
					&& A[i] != A[A[i] - 1]) {
				int t = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = t;
				i--;
			}
		}

		for (int j = 0; j < A.length; j++) {
			if (A[j] - 1 != j) {
				return j + 1;
			}
		}
		return A.length + 1;
	}
}