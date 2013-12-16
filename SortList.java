

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		slow = sortList(head);
		fast = sortList(fast);
		return merge(slow, fast);
	}

	private ListNode merge(ListNode slow, ListNode fast) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (slow != null && fast != null) {
			if (slow.val < fast.val) {
				cur.next = slow;
				slow = slow.next;
			} else {
				cur.next = fast;
				fast = fast.next;
			}
			cur = cur.next;
		}
		if (slow != null) {
			cur.next = slow;
		} else if (fast != null) {
			cur.next = fast;
		}
		return head.next;
	}
}
