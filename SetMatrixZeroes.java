

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up: 
 * Did you use extra space? 
 * A straight forward solution using O(mn) space is probably a bad idea. 
 * A simple improvement uses O(m + n) space, but still not the best solution. 
 * Could you devise a constant space solution?
 */

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					for (int k = 0; k < col; k++) {
						if (matrix[i][k] != 0)
							matrix[i][k] = -1;
					}
					for (int f = 0; f < row; f++) {
						if (matrix[f][j] != 0)
							matrix[f][j] = -1;
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}