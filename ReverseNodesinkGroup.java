/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * <p>If the number of nodes is not a multiple of k then left-out nodes in the end should remain as
 * it is.
 *
 * <p>You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * <p>Only constant memory is allowed.
 *
 * <p>For example,
 *
 * <p>Given this linked list: 1->2->3->4->5
 *
 * <p>For k = 2, you should return: 2->1->4->3->5
 *
 * <p>For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k < 2) {
      return head;
    }
    int count = 0;
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode start = head;
    ListNode end = start;
    while (count < k - 1 && end != null && end.next != null) {
      count++;
      end = end.next;
    }
    if (count == k - 1) {
      ListNode nextStart = end.next;
      end.next = null;
      reverseList(start);
      root.next = end;
      start.next = reverseKGroup(nextStart, k);
    }
    return root.next;
  }

  private void reverseList(ListNode start) {
    ListNode next;
    ListNode cur = start;
    ListNode prev = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
  }
}
