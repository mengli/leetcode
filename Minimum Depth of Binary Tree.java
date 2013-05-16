Minimum Depth of Binary TreeOct 10 '12
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
    	else {
			int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
			int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
			return Math.min(leftDepth, rightDepth) + 1;
		}
    }
}