package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesfromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null)
      return head;
    ListNode p = head.next;
    while (p != null && head.val == p.val)
      p = p.next;
    head.next = deleteDuplicates(p);
    return head;
  }
}
