Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    public ListNode partition(ListNode head, int x) {
    	ListNode low = null;
		ListNode high = null;
		ListNode cl = null;
    	ListNode ch = null;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				ListNode newNode = new ListNode(cur.val);
				if (low != null) {
					cl.next = newNode;
				} else {
    			    low = newNode;   
				}
				cl = newNode;
			} else {
				ListNode newNode = new ListNode(cur.val);
				if (high != null) {
					ch.next = newNode;
				} else {
    			    high = newNode;   
				}
				ch = newNode;
			}
            cur = cur.next;
		}
		if (low != null) {
			cl.next = high;
			return low;
		} else {
			return high;
		}
	}
}