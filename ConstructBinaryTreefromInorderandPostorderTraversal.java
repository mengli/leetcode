

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * 
 * You may assume that duplicates do not exist in the tree.
 * 
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder,
			int ps, int pe) {
		if (is > ie || ps > pe)
			return null;
		int rootVal = postorder[pe];
		TreeNode root = new TreeNode(rootVal);
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == rootVal) {
				TreeNode left = buildTree(inorder, is, i - 1, postorder, ps, ps
						+ i - is - 1);
				TreeNode right = buildTree(inorder, i + 1, ie, postorder, pe
						- ie + i, pe - 1);
				root.left = left;
				root.right = right;
			}
		}
		return root;
	}
}