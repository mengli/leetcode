

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 *
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 */

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.left != null) {
			TreeNode tmp = root.right;
			root.right = root.left;
			root.left = null;
			TreeNode rightMost = findRightMostNode(root.right);
			rightMost.right = tmp;
			flatten(root.right);
		} else if (root.right != null) {
			flatten(root.right);
		}
	}

	public TreeNode findRightMostNode(TreeNode root) {
		if (root.right != null) {
			return findRightMostNode(root.right);
		} else {
			return root;
		}
	}
}