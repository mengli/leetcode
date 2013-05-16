Balanced Binary TreeOct 9 '12
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
    public boolean isBalanced(TreeNode root) {
    	return determine(root) >= 0 ? true : false;
	}
	
	public int determine(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = determine(root.left);
			int rightDepth = determine(root.right);
			if (leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) return -1;
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}
}