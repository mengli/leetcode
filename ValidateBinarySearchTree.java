

/** 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return validate(root.left, Integer.MIN_VALUE, root.val)
				&& validate(root.right, root.val, Integer.MAX_VALUE);
	}

	private boolean validate(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val > min && root.val < max) {
			return validate(root.left, min, root.val)
					&& validate(root.right, root.val, max);
		} else {
			return false;
		}
	}
}