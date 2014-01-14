/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 */

public class NQueensII {
	public int solveNQueens(int n) {
		if (n == 0)
			return 0;
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
		int[] count = new int[1];
		findSolutions(n, 0, sol, row, cols, count);
		return count[0];
	}

	private void findSolutions(int n, int start, StringBuffer[] sol, int[] row,
			boolean[] cols, int[] count) {
		if (start == n) {
			count[0]++;
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
					findSolutions(n, start + 1, sol, row, cols, count);
					row[start] = 0;
					sol[start].setCharAt(i, '.');
					cols[i] = false;
				}
			}
		}
	}
}
