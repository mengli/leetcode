/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 */

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return head;
		int length = 1;
		ListNode last = head;
		while (last.next != null) {
			last = last.next;
			length++;
		}
		n = n % length;
		if (n == 0)
			return head;
		int steps = length - n;
		ListNode start = new ListNode(0);
		start.next = head;
		while (steps > 0) {
			start = start.next;
			steps--;
		}
		ListNode ret = start.next;
		start.next = null;
		last.next = head;
		return ret;
	}
}
