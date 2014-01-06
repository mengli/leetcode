/**
 * Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
 *
 *
 *       _______3______
 *      /              \
 *   ___5__          ___1__
 *  /      \        /      \
 *  6      _2       0       8
 *        /  \
 *        7   4
 * If you are not so sure about the definition of lowest common ancestor (LCA), please refer to my previous 
 * post: Lowest Common Ancestor of a Binary Search Tree (BST) or the definition of LCA here. Using the tree 
 * above as an example, the LCA of nodes 5 and 1 is 3. Please note that LCA for nodes 5 and 4 is 5.
 *
 * Hint:
 * Top-down or bottom-up? Consider both approaches and see which one is more efficient.
 */
public class LowestCommonAncestorOfBinaryTree {
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}
