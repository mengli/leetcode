

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 */

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		else {
			int p = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != elem) {
					A[p++] = A[i];
				}
			}
			return p;
		}
	}
}