

import java.util.ArrayList;

/** 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 */

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root != null) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			findPathSum(root, sum, result, path);
		}
		return result;
	}

	public void findPathSum(TreeNode root, int sum,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
		if (root == null)
			return;
		if (root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> clone = new ArrayList<Integer>(path);
			clone.add(root.val);
			result.add(clone);
		} else {
			path.add(root.val);
			if (root.left != null) {
				findPathSum(root.left, sum - root.val, result, path);
			}
			if (root.right != null) {
				findPathSum(root.right, sum - root.val, result, path);
			}
			path.remove(path.size() - 1);
		}
	}
}