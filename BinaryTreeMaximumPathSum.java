/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 *   1 
 *  / \ 
 * 2   3
 * 
 * Return 6.
 * 
 */

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSum(root, max);
		return max[0];
	}

	private int maxPathSum(TreeNode root, int[] max) {
		if (root.left == null && root.right == null) {
			max[0] = root.val > max[0] ? root.val : max[0];
			return root.val;
		} else if (root.left != null && root.right == null) {
			int left = maxPathSum(root.left, max);
			max[0] = left > 0 ? Math.max(left + root.val, max[0]) : Math.max(
					root.val, max[0]);
			return left > 0 ? left + root.val : root.val;
		} else if (root.left == null && root.right != null) {
			int right = maxPathSum(root.right, max);
			max[0] = right > 0 ? Math.max(right + root.val, max[0]) : Math.max(
					root.val, max[0]);
			return right > 0 ? right + root.val : root.val;
		} else {
			int left = maxPathSum(root.left, max);
			int right = maxPathSum(root.right, max);
			int tmp = root.val;
			tmp += left > 0 ? left : 0;
			tmp += right > 0 ? right : 0;
			max[0] = tmp > max[0] ? tmp : max[0];
			return Math.max(Math.max(left, right), 0) + root.val;
		}
	}
}