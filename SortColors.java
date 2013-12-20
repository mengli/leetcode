

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: 
 * 
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up: 
 * A rather straight forward solution is a two-pass algorithm using counting sort. 
 * 
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 */

public class SortColors {
	public void sortColors(int[] A) {
		int length = A.length;
		int left = -1;
		int right = length;
		int i = 0;
		while (i < right) {
			if (A[i] == 0) {
				swap(A, ++left, i++);
			} else if (A[i] == 2) {
				swap(A, i, --right);
			} else {
				i++;
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}