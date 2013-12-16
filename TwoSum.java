

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class TwoSum {
	public class Num {
		private int value;
		private int index;

		public Num(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		Num[] newArray = new Num[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			newArray[i] = new Num(numbers[i], i);
		}
		Arrays.sort(newArray, new Comparator<Num>() {
			public int compare(Num n1, Num n2) {
				if (n1.getValue() == n2.getValue())
					return 0;
				if (n1.getValue() > n2.getValue())
					return 1;
				return -1;
			}
		});
		int[] result = new int[2];
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int tmp = newArray[i].getValue() + newArray[j].getValue();
			if (tmp == target) {
				result[0] = Math.min(newArray[i].getIndex() + 1,
						newArray[j].getIndex() + 1);
				result[1] = Math.max(newArray[i].getIndex() + 1,
						newArray[j].getIndex() + 1);
				break;
			} else if (tmp > target) {
				j--;
			} else {
				i++;
			}
		}
		return result;
	}
}