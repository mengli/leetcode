/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 */

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int maxArea = 0;
		int cols = matrix[0].length;
		int[][] map = new int[rows][cols];
		for (int j = 0; j < cols; j++) {
			map[0][j] = matrix[0][j] == '0' ? 0 : 1;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				map[i][j] = matrix[i][j] == '0' ? map[i - 1][j]
						: map[i - 1][j] + 1;
			}
		}
		int[] row = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < rows; j++) {
				for (int k = 0; k < cols; k++) {
					row[k] = map[j][k] - (i == 0 ? 0 : map[i - 1][k]);
				}
				int count = 0;
				for (int k = 0; k < cols; k++) {
					if (row[k] == j - i + 1) {
						maxArea = Math.max(maxArea, ++count * (j - i + 1));
					} else {
						maxArea = Math.max(maxArea, count * (j - i + 1));
						count = 0;
					}
				}
			}
		}
		return maxArea;
	}
}