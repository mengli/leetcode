

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], 
 *   ["SFCS"], 
 *   ["ADEE"] 
 * ] 
 * 
 * word = "ABCCED", -> returns true, 
 * word = "SEE", -> returns true, 
 * word = "ABCB", -> returns false.
 */

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int height = board.length;
		int width = board[0].length;
		boolean[][] map = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (search(board, map, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, boolean[][] map, int x, int y,
			String word, int index) {
		if (word.charAt(index) != board[x][y]) {
			return false;
		}
		if (index == word.length() - 1) {
			return true;
		}

		int height = board.length;
		int width = board[0].length;
		map[x][y] = true;

		if (x > 0 && !map[x - 1][y]
				&& search(board, map, x - 1, y, word, index + 1)) {
			return true;
		}

		if (x < height - 1 && !map[x + 1][y]
				&& search(board, map, x + 1, y, word, index + 1)) {
			return true;
		}

		if (y > 0 && !map[x][y - 1]
				&& search(board, map, x, y - 1, word, index + 1)) {
			return true;
		}

		if (y < width - 1 && !map[x][y + 1]
				&& search(board, map, x, y + 1, word, index + 1)) {
			return true;
		}

		map[x][y] = false;

		return false;
	}
}