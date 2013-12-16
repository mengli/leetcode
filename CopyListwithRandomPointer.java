

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode newNode = new RandomListNode(cur.label);
			newNode.next = cur.next;
			cur.next = newNode;
			cur = newNode.next;
		}
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		cur = head.next;
		RandomListNode newHead = cur;
		RandomListNode old = head;
		while (old != null) {
			old.next = old.next.next;
			if (old.next != null) {
				cur.next = old.next.next;
			}
			cur = cur.next;
			old = old.next;
		}
		return newHead;
	}
}