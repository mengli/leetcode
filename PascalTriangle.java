

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [      
 *        [1], 
 *       [1,1], 
 *      [1,2,1], 
 *     [1,3,3,1], 
 *    [1,4,6,4,1] 
 * ]
 */

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) {
		ArrayList<ArrayList<Integer>> pt = new ArrayList<ArrayList<Integer>>();
		int k = 1;
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> r = new ArrayList<Integer>();
			for (int j = 0; j < k; j++) {
				r.add(1);
			}
			k++;
			pt.add(r);
		}
		for (int f = 2; f < pt.size(); f++) {
			ArrayList<Integer> prev = pt.get(f - 1);
			ArrayList<Integer> current = pt.get(f);
			for (int g = 1; g < current.size() - 1; g++) {
				current.set(g, prev.get(g - 1) + prev.get(g));
			}
		}
		return pt;
	}
}