/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 */

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode slow = start;
		ListNode fast = head;
		while (fast.next != null) {
			if (slow.next.val != fast.next.val) {
				if (slow.next.next == fast.next) {
					slow = slow.next;
				} else {
					slow.next = fast.next;
				}
			}
			fast = fast.next;
		}
		if (slow.next.next != fast.next) {
			slow.next = fast.next;
		}
		return start.next;
	}
}