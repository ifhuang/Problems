package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesinkGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1)
      return head;
    int copy = k;
    ListNode p = head;
    while (copy-- > 0) {
      p = p.next;
      if (p == null)
        break;
    }
    if (copy > 0)
      return head;
    ListNode p1 = head;
    ListNode p2 = head.next;
    p1.next = reverseKGroup(p, k);
    copy = k;
    while (copy-- > 1) {
      ListNode p3 = p2.next;
      p2.next = p1;
      p1 = p2;
      p2 = p3;
    }
    return p1;
  }
}
