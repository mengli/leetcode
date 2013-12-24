
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
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
		}
		int totalCandy = candy[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			candy[i] = (ratings[i] > ratings[i + 1] && candy[i + 1] + 1 > candy[i]) ? candy[i + 1] + 1 : candy[i];
			totalCandy += candy[i];
		}
		return totalCandy;
	}
}