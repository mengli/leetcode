

/** 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 */

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return sum(root, 0);
		}
	}

	public int sum(TreeNode root, int prev) {
		if (root.left == null && root.right == null) {
			return 10 * prev + root.val;
		} else if (root.left != null && root.right != null) {
			return sum(root.left, 10 * prev + root.val)
					+ sum(root.right, 10 * prev + root.val);
		} else if (root.left != null) {
			return sum(root.left, 10 * prev + root.val);
		} else {
			return sum(root.right, 10 * prev + root.val);
		}
	}
}