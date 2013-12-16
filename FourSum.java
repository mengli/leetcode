

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? 
 * 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		int length = num.length;
		for (int i = 0; i < length - 3; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j < length - 2; j++) {
				if (j > i + 1 && num[j] == num[j - 1])
					continue;
				int l = j + 1;
				int r = length - 1;
				while (l < r) {
					int delta = num[i] + num[j] + num[l] + num[r] - target;
					if (delta == 0) {
						if (l > j + 1 && num[l] == num[l - 1]) {
							l++;
							continue;
						}
						if (r < length - 1 && num[r] == num[r + 1]) {
							r--;
							continue;
						}
						ArrayList<Integer> item = new ArrayList<Integer>();
						item.add(num[i]);
						item.add(num[j]);
						item.add(num[l]);
						item.add(num[r]);
						ret.add(item);
						l++;
						r--;
					} else if (delta < 0) {
						l++;
					} else {
						r--;
					}
				}
			}
		}
		return ret;
	}
}