/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * 
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 *  ]
 */

import java.util.ArrayList;

public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		if (n == 0)
			return ret;
		StringBuffer line = new StringBuffer();
		for (int i = 0; i < n; i++) {
			line.append('.');
		}
		StringBuffer[] sol = new StringBuffer[n];
		for (int i = 0; i < n; i++) {
			sol[i] = new StringBuffer(line.toString());
		}
		boolean[] cols = new boolean[n];
		int[] row = new int[n];
		findSolutions(n, 0, ret, sol, row, cols);
		return ret;
	}

	private void findSolutions(int n, int start, ArrayList<String[]> ret,
			StringBuffer[] sol, int[] row, boolean[] cols) {
		if (start == n) {
			String[] newSol = new String[n];
			for (int i = 0; i < n; i++) {
				newSol[i] = sol[i].toString();
			}
			ret.add(newSol);
		} else {
			for (int i = 0; i < n; i++) {
				if (cols[i])
					continue;
				boolean ok = true;
				for (int j = 0; j < start; j++) {
					if (Math.abs(start - j) == Math.abs(i - row[j])) {
						ok = false;
						break;
					}
				}
				if (ok) {
					cols[i] = true;
					sol[start].setCharAt(i, 'Q');
					row[start] = i;
					findSolutions(n, start + 1, ret, sol, row, cols);
					row[start] = 0;
					sol[start].setCharAt(i, '.');
					cols[i] = false;
				}
			}
		}
	}
}
