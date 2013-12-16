

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 */

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n == 0)
			return;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = t;
			}
		}
	}
}