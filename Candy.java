

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 */

public class Candy {
	public int candy(int[] ratings) {
		int[] A = new int[ratings.length];
		for (int i = 0; i < A.length; i++) {
			A[i] = 1;
		}
		for (int j = 1; j < A.length; j++) {
			check(A, ratings, j);
		}
		int sum = 0;
		for (int k = 0; k < A.length; k++) {
			sum += A[k];
		}
		return sum;
	}

	private void check(int[] plan, int[] ratings, int start) {
		while (start > 0) {
			if (ratings[start - 1] > ratings[start]
					&& plan[start - 1] <= plan[start]) {
				plan[start - 1] = plan[start] + 1;
			} else if (ratings[start - 1] < ratings[start]
					&& plan[start - 1] >= plan[start]) {
				plan[start] = plan[start - 1] + 1;
			} else {
				return;
			}
			start--;
		}
	}
}