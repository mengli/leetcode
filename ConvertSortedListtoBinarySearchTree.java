/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		return sortedListToBST(head, null);
	}

	private TreeNode sortedListToBST(ListNode start, ListNode end) {
		if (start == end) {
			return null;
		} else if (start.next == end) {
			return new TreeNode(start.val);
		} else {
			ListNode fast = start, slow = start;
			while (fast.next != end && fast.next.next != end) {
				fast = fast.next.next;
				slow = slow.next;
			}
			TreeNode left = sortedListToBST(start, slow);
			TreeNode right = sortedListToBST(slow.next, end);
			TreeNode root = new TreeNode(slow.val);
			root.left = left;
			root.right = right;
			return root;
		}
	}
}