/** 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL. 
 */

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode low = start;
		ListNode high = start;
		ListNode p1 = null;
		ListNode p2 = null;
		for (int i = 0; i < m - 1; i++) {
			low = low.next;
		}
		p1 = low;
		low = low.next;
		for (int i = 0; i < n; i++) {
			high = high.next;
		}
		p2 = high.next;
		high.next = null;
		p1.next = reverseList(low);
		while (p1.next != null) {
			p1 = p1.next;
		}
		p1.next = p2;
		return start.next;
	}

	private ListNode reverseList(ListNode low) {
		ListNode cur = low;
		ListNode prev = null;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}