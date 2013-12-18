

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 */

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length == 0) return 0;
		int profit = 0;
		int lowest = prices[0];
		int[] left = new int[length];
		int[] right = new int[length];
		for (int i = 1; i < length; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
			} else if (prices[i] - lowest > profit) {
				profit = prices[i] - lowest;
			}
			left[i] = profit;
		}
		profit = 0;
		int topest = prices[length - 1];
		for (int j = length - 2; j >= 0; j--) {
			if (prices[j] > topest) {
				topest = prices[j];
			} else if (topest - prices[j] > profit) {
				profit = topest - prices[j];
			}
			right[length - 1 - j] = profit;
		}
		profit = 0;
		for (int k = 0; k < length; k++) {
			int p = left[k] + right[length - 1 - k];
			if (p > profit) {
				profit = p;
			}
		}
		return profit;
	}
}