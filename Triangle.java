

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * 
 * Each step you may move to adjacent numbers on the row below. 
 * 
 * For example, given the following triangle 
 * [   
 *     [2], 
 *    [3,4], 
 *   [6,5,7], 
 *  [4,1,8,3] 
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: 
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int n = triangle.size() - 1;
		int[] path = new int[triangle.size()];
		for (int o = 0; o < triangle.get(n).size(); o++) {
			path[o] = triangle.get(n).get(o);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0, t = 0; j < triangle.get(i + 1).size() - 1; j++, t++) {
				path[t] = triangle.get(i).get(t)
						+ Math.min(path[j], path[j + 1]);
			}
		}
		return path[0];
	}
}