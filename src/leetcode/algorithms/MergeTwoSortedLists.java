package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
  // recursive
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else {
      ListNode small = l1;
      ListNode big = l2;
      if (l2.val < l1.val) {
        small = l2;
        big = l1;
      }
      small.next = mergeTwoLists(small.next, big);
      return small;
    }
  }

  // iterative
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null) {
      p.next = l1;
    } else if (l2 != null) {
      p.next = l2;
    }
    return dummy.next;
  }
}
