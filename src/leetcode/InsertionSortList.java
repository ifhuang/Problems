package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/insertion-sort-list/
public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode min = head;
    ListNode pre = null;
    ListNode p = head;
    ListNode q = head.next;
    while (q != null) {
      if (q.val < min.val) {
        pre = p;
        min = q;
      }
      p = p.next;
      q = q.next;
    }
    if (pre == null) {
      head.next = insertionSortList(head.next);
      return head;
    } else {
      pre.next = min.next;
      min.next = insertionSortList(head);
      return min;
    }
  }
}
