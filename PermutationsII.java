

import java.util.ArrayList;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: 
 * [1,1,2], [1,2,1], and [2,1,1].
 */

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	void permuteUnique(int[] num, int begin,
			ArrayList<ArrayList<Integer>> result) {
		if (begin > num.length - 1) {
			ArrayList<Integer> item = new ArrayList<Integer>();
			for (int h = 0; h < num.length; h++) {
				item.add(num[h]);
			}
			result.add(item);
		}
		for (int end = begin; end < num.length; end++) {
			if (isSwap(num, begin, end)) {
				swap(num, begin, end);
				permuteUnique(num, begin + 1, result);
				swap(num, begin, end);
			}
		}
	}

	boolean isSwap(int[] arr, int i, int j) {
		for (int k = i; k < j; k++) {
			if (arr[k] == arr[j]) {
				return false;
			}
		}
		return true;
	}
	
	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}