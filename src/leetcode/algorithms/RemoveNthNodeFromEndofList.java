package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndofList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode last = head;
    ListNode pre = head;
    while (n-- > 0)
      last = last.next;
    if (last == null)
      return head.next;
    while (last.next != null) {
      last = last.next;
      pre = pre.next;
    }
    pre.next = pre.next.next;
    return head;
  }
}
