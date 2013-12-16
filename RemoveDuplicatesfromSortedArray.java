

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 */

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A.length == 0)
			return 0;
		else if (A.length == 1)
			return 1;
		else {
			int ret = 1;
			int p = 0;
			for (int p1 = 1; p1 < A.length; p1++) {
				if (A[p1 - 1] != A[p1]) {
					ret++;
					A[++p] = A[p1];
				}
			}
			return ret;
		}
	}
}