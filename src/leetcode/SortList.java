package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/sort-list/
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode p = head;
    ListNode q = head;
    while (q != null && q.next != null && q.next.next != null) {
      p = p.next;
      q = q.next.next;
    }
    q = p.next;
    p.next = null;
    return merge(sortList(head), sortList(q));
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    else if (l2 == null)
      return l1;
    else if (l1.val < l2.val) {
      l1.next = merge(l1.next, l2);
      return l1;
    } else {
      l2.next = merge(l1, l2.next);
      return l2;
    }
  }
}
