Convert Sorted List to Binary Search TreeOct 3 '12
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode n = head;
        int size = 0;
        while (n != null) {
    		size++;
    		n = n.next;
    	}
    	int[] num = new int[size];
    	n = head;
    	int i = 0;
    	while (n != null) {
    		num[i++] = n.val;
    		n = n.next;
    	}
    	return sortedArrayToBST(num);
    }
    
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