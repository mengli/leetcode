/**
 * Lowest Common Ancestor of a Binary Search Tree (BST)
 *
 * Given a binary search tree (BST), find the lowest common ancestor of two given nodes in the BST.
 *
 *
 *       _______6______
 *      /              \
 *   ___2__          ___8__
 *  /      \        /      \
 *  0      _4       7       9
 *        /  \
 *        3   5
 * Using the above tree as an example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * But how about LCA of nodes 2 and 4? Should it be 6 or 2?
 *
 * According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor is defined between 
 * two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a 
 * node to be a descendant of itself).¡± Since a node can be a descendant of itself, the LCA of 2 and 
 * 4 should be 2, according to this definition.
 *
 * Hint:
 * A top-down walk from the root of the tree is enough.
 */
public class LowestCommonAncestorOfaBinarySearchTree {
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		if (Math.max(p.val, q.val) < root.val)
			return LCA(root.left, p, q);
		if (Math.min(p.val, q.val) > root.val)
			return LCA(root.right, p, q);
		return root;
	}
}
