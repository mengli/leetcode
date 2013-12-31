/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return head;
		ListNode fast = head, slow = head;
		do {
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			} else {
				return null;
			}
		} while (fast != slow);
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
