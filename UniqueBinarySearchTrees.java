

/** 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * 
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] record = new int[n + 1];
		record[0] = 1;
		record[1] = 1;
		record[2] = 2;
		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int k = 0; k < i; k++) {
				tmp += (record[k] * record[i - k - 1]);
			}
			record[i] = tmp;
		}
		return record[n];
	}
}