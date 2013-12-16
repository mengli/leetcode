

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */

public class SingleNumber {
	public int singleNumber(int[] A) {
		int ret = A[0];
		for (int i = 1; i < A.length; i++) {
			ret ^= A[i];
		}
		return ret;
	}
}