import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		int dis = Integer.MAX_VALUE;
		int ret = 0;
		Arrays.sort(num);
		int length = num.length;
		for (int i = 0; i < length - 2; i++) {
			int j = i + 1;
			int k = length - 1;
			while (j < k) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					j++;
					continue;
				}
				if (k < length - 1 && num[k] == num[k + 1]) {
					k--;
					continue;
				}
				int sum = num[i] + num[j] + num[k];
				int minus = sum - target;
				int d = Math.abs(minus);
				if (d < dis) {
					dis = d;
					ret = sum;
				}
				if (minus == 0)
					return target;
				if (minus < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return ret;
	}
}
