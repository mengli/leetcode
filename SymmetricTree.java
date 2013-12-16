

import java.util.ArrayList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *   \   \
 *   3    3
 * Note:
 * 
 * Bonus points if you could solve it both recursively and iteratively.
 */

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		ArrayList<String> inOrder = new ArrayList<String>();
		inOrder(root, inOrder);
		int start = 0, end = inOrder.size() - 1;
		while (start < end) {
			if (inOrder.get(start).equals(inOrder.get(end))) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public void inOrder(TreeNode root, ArrayList<String> inOrder) {
		if (root == null) {
			inOrder.add("#");
			return;
		}
		inOrder(root.left, inOrder);
		inOrder.add(root.val + "");
		inOrder(root.right, inOrder);
	}
}