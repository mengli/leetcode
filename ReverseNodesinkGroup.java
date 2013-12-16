

/** 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * 
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */

public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		int t = 0;
		ListNode nextHead = head;
		while (nextHead != null && t < k - 1) {
			nextHead = nextHead.next;
			t++;
		}
		if (nextHead == null || t < k - 1) {
			return head;
		} else {
			ListNode nextPart = reverseKGroup(nextHead.next, k);
			return reverseList(head, k, nextPart);
		}
	}

	private ListNode reverseList(ListNode head, int k, ListNode nextPart) {
		ListNode cur = head, prev = null, next = null;
		for (int i = 0; i < k; i++) {
			next = cur.next;
			if (i != 0) {
				cur.next = prev;
			} else {
				cur.next = nextPart;
			}
			prev = cur;
			cur = next;
		}
		return prev;
	}
}