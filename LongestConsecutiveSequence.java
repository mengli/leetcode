

import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		int max = 0;
		HashSet<Integer> h = new HashSet<Integer>();
		for (int n : num) {
			h.add(n);
		}
		for (int n : num) {
			max = Math.max(max, getCount(h, n, false)
					+ getCount(h, n + 1, true));
		}
		return max;
	}

	public int getCount(HashSet<Integer> h, int value, boolean asc) {
		int count = 0;
		while (h.contains(value)) {
			count++;
			h.remove(value);
			if (asc)
				value++;
			else
				value--;
		}
		return count;
	}
}