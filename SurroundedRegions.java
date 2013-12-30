

import java.util.LinkedList;
import java.util.Queue;

/** 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */

public class SurroundedRegions {
	public void solve(char[][] board) {
		int row = board.length;
		if (row == 0)
			return;
		int col = board[0].length;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((i == 0 || i == row - 1 || j == 0 || j == col - 1)
						&& board[i][j] == 'O') {
					qx.add(i);
					qy.add(j);
				}
			}
		}
		while (!qx.isEmpty()) {
			int x = qx.remove();
			int y = qy.remove();
			board[x][y] = '@';
			if (x > 0 && board[x - 1][y] == 'O') {
				qx.add(x - 1);
				qy.add(y);
			}
			if (x < row - 1 && board[x + 1][y] == 'O') {
				qx.add(x + 1);
				qy.add(y);
			}
			if (y > 0 && board[x][y - 1] == 'O') {
				qx.add(x);
				qy.add(y - 1);
			}
			if (y < col - 1 && board[x][y + 1] == 'O') {
				qx.add(x);
				qy.add(y + 1);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '@') {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
	}
}