package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndofList {
  // time O(n), space O(1)
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode b = head;
    while (n-- > 0) {
      b = b.next;
    }
    // let's remove the head
    if (b == null) {
      return head.next;
    }
    ListNode a = head;
    while (b.next != null) {
      a = a.next;
      b = b.next;
    }
    a.next = a.next.next;
    return head;
  }
}
