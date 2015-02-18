package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    ListNode f = head;
    ListNode s = head;
    while (s != null && s.next != null) {
      f = f.next;
      s = s.next.next;
      if (f == s)
        break;
    }
    if (s == null || s.next == null)
      return null;
    s = head;
    while (f != s) {
      f = f.next;
      s = s.next;
    }
    return f;
  }
}
