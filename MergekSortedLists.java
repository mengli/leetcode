

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/** 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 *
 */

public class MergekSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.isEmpty())
			return null;

		Comparator<ListNode> comp = new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				if (o1.val > o2.val)
					return 1;
				return 0;
			}
		};
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), comp);
		for (ListNode node : lists) {
			if (node != null)
				heap.add(node);
		}
		ListNode head = null, cur = null;
		while (!heap.isEmpty()) {
			if (head == null) {
				head = heap.poll();
				cur = head;
			} else {
				cur.next = heap.poll();
				cur = cur.next;
			}
			if (cur.next != null)
				heap.add(cur.next);
		}
		return head;
	}
}