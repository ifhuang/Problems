package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/partition-list/
public class PartitionList {
  // time O(n), space O(1)
  public ListNode partition(ListNode head, int x) {
    ListNode d1 = new ListNode(0);
    ListNode p1 = d1;
    ListNode d2 = new ListNode(0);
    ListNode p2 = d2;
    ListNode p = head;
    while (p != null) {
      if (p.val < x) {
        p1.next = p;
        p1 = p1.next;
      } else {
        p2.next = p;
        p2 = p2.next;
      }
      p = p.next;
    }
    p2.next = null;
    p1.next = d2.next;
    return d1.next;
  }
}
