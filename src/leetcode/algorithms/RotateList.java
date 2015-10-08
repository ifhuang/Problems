package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/rotate-list/
public class RotateList {
  // time O(n), space O(1)
  public ListNode rotateRight(ListNode head, int k) {
    int c = 0;
    ListNode p = head;
    while (p != null) {
      c++;
      p = p.next;
    }
    if (c == 0) {
      return head;
    }
    k %= c;
    p = head;
    while (k-- > 0) {
      p = p.next;
    }
    ListNode q = head;
    while (p.next != null) {
      p = p.next;
      q = q.next;
    }
    p.next = head;
    p = q.next;
    q.next = null;
    return p;
  }
}
