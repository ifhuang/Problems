package leetcode.algorithms;

import leetcode.util.ListNode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesfromSortedListII {
  // recursive
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode p = head.next;
    while (p != null && p.val == head.val) {
      p = p.next;
    }
    if (p == head.next) {
      head.next = deleteDuplicates(p);
      return head;
    } else {
      return deleteDuplicates(p);
    }
  }

  // iterative
  public ListNode deleteDuplicates2(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    ListNode p = head;
    while (p != null) {
      ListNode q = p.next;
      while (q != null && q.val == p.val) {
        q = q.next;
      }
      if (p.next == q) {
        pre.next = p;
        pre = pre.next;
      }
      p = q;
    }
    pre.next = null;
    return dummy.next;
  }
}
