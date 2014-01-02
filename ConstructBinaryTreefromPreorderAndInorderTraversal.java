/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * 
 * You may assume that duplicates do not exist in the tree.
 */

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int length1 = preorder.length;
		int length2 = inorder.length;
		return buildTree(preorder, 0, length1, inorder, 0, length2);
	}

	private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder,
			int s2, int e2) {
		if (s1 >= e1 || s2 >= e2) {
			return null;
		}
		if (s1 + 1 == e1) {
			return new TreeNode(preorder[s1]);
		}
		int mid = preorder[s1];
		int i = s2;
		for (; i < e2; i++) {
			if (inorder[i] == mid) {
				break;
			}
		}
		TreeNode left = buildTree(preorder, s1 + 1, s1 + 1 + i - s2, inorder,
				s2, i);
		TreeNode right = buildTree(preorder, s1 + 1 + i - s2, e1, inorder,
				i + 1, e2);
		TreeNode root = new TreeNode(preorder[s1]);
		root.left = left;
		root.right = right;
		return root;
	}
}
