Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p1 = root;
        int i = 0;
        while (i < n && p1.next != null) {
        	i++;
        	p1 = p1.next;
        }
        ListNode p2 = root;
        while (p1.next != null) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p2.next = p2.next.next;
        return root.next;
    }
}