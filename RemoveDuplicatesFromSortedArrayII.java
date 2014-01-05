/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * 
 * For example,
 * 
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int length = A.length;
		if (length < 3)
			return length;
		int slow = 0, fast = 1, idx = 0;
		while (fast < length) {
			while (fast < length && A[fast] == A[slow]) {
				fast++;
			}
			if (fast - slow <= 2) {
				while (slow < fast) {
					A[idx++] = A[slow++];
				}
			} else {
				A[idx++] = A[slow++];
				A[idx++] = A[slow++];
				slow = fast;
			}
			fast++;
		}
		while (slow < length) {
			A[idx++] = A[slow++];
		}
		return idx;
	}
}