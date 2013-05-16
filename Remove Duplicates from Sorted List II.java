Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode begin = head;
		ListNode cur = head;
		ListNode newHead = null;
		ListNode newTail = null;
		while (cur != null) {
			while (cur.next != null && begin.val == cur.next.val) {
				cur = cur.next;
			}
			if (begin != cur) {
				begin = cur.next;
				cur = cur.next;
			} else {
				ListNode tmp = begin;
				begin = begin.next;
				cur = cur.next;
				if (newHead == null) {
					newHead = tmp;
					newTail = tmp;
				} else {
					newTail.next = tmp;
					newTail = newTail.next;
				}
				newTail.next = null;
			}
		}
		return newHead;
	}
}