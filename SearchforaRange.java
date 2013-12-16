

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */

public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int low = findLow(A, target, 0, A.length - 1);
		int high = findHigh(A, target, 0, A.length - 1);
		int[] ret = new int[2];
		ret[0] = low;
		ret[1] = high;
		return ret;
	}

	private int findLow(int[] A, int target, int l, int r) {
		int mid = 0;
		int ret = -1;
		while (l <= r) {
			mid = (l + r) / 2;
			if (A[mid] == target) {
				ret = mid;
				int next = findLow(A, target, l, mid - 1);
				if (next != -1) {
					ret = next;
				}
				break;
			} else if (A[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}

		}
		return ret;
	}

	private int findHigh(int[] A, int target, int l, int r) {
		int mid = 0;
		int ret = -1;
		while (l <= r) {
			mid = (l + r) / 2;
			if (A[mid] == target) {
				ret = mid;
				int next = findHigh(A, target, mid + 1, r);
				if (next != -1) {
					ret = next;
				}
				break;
			} else if (A[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ret;
	}
}