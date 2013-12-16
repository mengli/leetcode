

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based. You may
 * assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class TwoSumV2 {
	private void quickSort(int[] numbers, int[] indexs, int start, int end) {
		if (start < end) {
			int p = partition(numbers, indexs, start, end);
			quickSort(numbers, indexs, start, p - 1);
			quickSort(numbers, indexs, p + 1, end);
		}
	}

	private int partition(int[] numbers, int[] indexs, int start, int end) {
		swap(numbers, (start + end) / 2, end);
		swap(indexs, (start + end) / 2, end);
		int x = numbers[end];
		int i = start - 1;
		for (int k = start; k < end; k++) {
			if (numbers[k] < x) {
				i++;
				swap(numbers, i, k);
				swap(indexs, i, k);
			}
		}
		swap(numbers, i + 1, end);
		swap(indexs, i + 1, end);
		return i + 1;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		int[] indexs = new int[len];
		int[] ret = new int[2];
		for (int i = 0; i < len; i++) {
			indexs[i] = i + 1;
		}
		quickSort(numbers, indexs, 0, len - 1);
		int start = 0;
		int end = len - 1;
		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				ret[0] = Math.min(indexs[start], indexs[end]);
				ret[1] = Math.max(indexs[start], indexs[end]);
				break;
			} else if (numbers[start] + numbers[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		return ret;
	}
}
