/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example,
 * 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 */

public class TrappingRainWater {
	public int trap(int A[], int n) {
		if (n <= 2)
			return 0;

		int[] lmh = new int[n];
		lmh[0] = 0;
		int maxh = A[0];
		for (int i = 1; i < n; ++i) {
			lmh[i] = maxh;
			if (maxh < A[i])
				maxh = A[i];
		}
		int trapped = 0;
		maxh = A[n - 1];
		for (int i = n - 2; i > 0; --i) {
			int left = lmh[i];
			int right = maxh;
			int container = Math.min(left, right);
			if (container > A[i]) {
				trapped += container - A[i];
			}
			if (maxh < A[i])
				maxh = A[i];
		}
		return trapped;
	}
}
