

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode fast = head;
		ListNode late = head;
		do {
			fast = fast.next;
			late = late.next;
			if (late == null) {
				return false;
			} else {
				late = late.next;
				if (fast == late) {
					return true;
				}
			}
		} while(fast != null && late != null);
		return false;
	}
}
