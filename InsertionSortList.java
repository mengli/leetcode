

/**
 * Sort a linked list using insertion sort.
 * 
 */

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode ret = new ListNode(Integer.MIN_VALUE);
		ListNode result = ret;
		ListNode cur = new ListNode(0);
		cur.next = head;
		while (cur.next != null) {
			while (result.next != null && cur.next.val > result.next.val) {
				result = result.next;
			}
			ListNode tmp = cur.next;
			cur.next = cur.next.next;
			if (result.next == null) {
				result.next = tmp;
				tmp.next = null;
			} else {
				ListNode tmp2 = result.next;
				result.next = tmp;
				tmp.next = tmp2;
			}
			result = ret;
		}
		return result.next;
	}
}
