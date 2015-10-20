package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    ListNode m = helper(head);
    if (m == null) {
      return null;
    }
    ListNode p = head;
    while (p != m) {
      p = p.next;
      m = m.next;
    }
    return p;
  }

  private ListNode helper(ListNode head) {
    ListNode f = head;
    ListNode s = head;
    while (s != null && s.next != null) {
      f = f.next;
      s = s.next.next;
      if (f == s) {
        return f;
      }
    }
    return null;
  }
}
