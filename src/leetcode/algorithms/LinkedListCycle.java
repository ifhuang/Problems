package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    ListNode f = head;
    ListNode s = head;
    while (s != null && s.next != null) {
      f = f.next;
      s = s.next.next;
      if (f == s)
        return true;
    }
    return false;
  }
}
