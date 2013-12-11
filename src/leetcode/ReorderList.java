package leetcode;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;
		ListNode cur = head;
		ListNode prev = null;
		while(cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		ListNode next = head.next;
		head.next = cur;
		prev.next = cur.next;
		cur.next = next;
		reorderList(next);
	}
	
	public static void main(String[] args) {
		ListNode head0 = new ListNode(0);
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		//ListNode head4 = new ListNode(4);
		head0.next = head1;
		head1.next = head2;
		head2.next = head3;
		//head3.next = head4;
		new ReorderList().reorderList(head0);
	}
}