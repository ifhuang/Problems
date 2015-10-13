package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesfromSortedList {
  // recursive
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode p = head.next;
    while (p != null && p.val == head.val) {
      p = p.next;
    }
    head.next = deleteDuplicates(p);
    return head;
  }

  // iterative
  public ListNode deleteDuplicates2(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      if (cur.val != pre.val) {
        pre.next = cur;
        pre = cur;
      }
      cur = cur.next;
    }
    pre.next = null;
    return head;
  }
}
