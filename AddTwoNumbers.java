

/**
 * You are given two linked lists representing two non-negative numbers. 
 * 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		int plus = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + plus;
			plus = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 != null) {
			if (plus != 0) {
				cur.next = addTwoNumbers(l1, new ListNode(plus));
			} else {
				cur.next = l1;
			}
		} else if (l2 != null) {
			if (plus != 0) {
				cur.next = addTwoNumbers(l2, new ListNode(plus));
			} else {
				cur.next = l2;
			}
		} else if (plus != 0) {
			cur.next = new ListNode(plus);
		}

		return head.next;
	}
}