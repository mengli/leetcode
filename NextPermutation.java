

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. 
 * 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 */

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int i1 = 0;
		int i2 = 0;
		int i = num.length - 1;
		int j = 0;
		while (i > 0 && num[i - 1] >= num[i]) {
			i--;
		}
		if (i == 0) {
			Arrays.sort(num);
			return;
		} else {
			i1 = i - 1;
		}
		j = i1 + 1;
		while (j < num.length && num[i1] < num[j]) {
			j++;
		}
		i2 = j - 1;
		int temp = num[i1];
		num[i1] = num[i2];
		num[i2] = temp;
		Arrays.sort(num, i1 + 1, num.length);
	}
}