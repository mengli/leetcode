Convert Sorted Array to Binary Search TreeOct 2 '12
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
    	return sortedArrayToBST(num, 0, num.length - 1);
	}
	
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			TreeNode left = sortedArrayToBST(num, start, mid - 1);
			TreeNode right = sortedArrayToBST(num, mid + 1, end);
			TreeNode node = new TreeNode(num[mid]);
			node.left = left;
			node.right = right;
			return node;
		}
		return null;
	}
}