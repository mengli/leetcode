/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		int ones = 0, twos = 0, xthrees = 0;
		for (int i = 0; i < A.length; ++i) {
			twos |= (ones & A[i]);
			ones ^= A[i];
			xthrees = ~(ones & twos);
			ones &= xthrees;
			twos &= xthrees;
		}
		return ones;
	}
}
