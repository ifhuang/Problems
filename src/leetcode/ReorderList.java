package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/reorder-list/
public class ReorderList {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
      return;
    ListNode f = head;
    ListNode s = head;
    while (s.next != null && s.next.next != null) {
      f = f.next;
      s = s.next.next;
    }
    ListNode l1 = head;
    ListNode l2 = f.next;
    f.next = null;
    merge(l1, reverse(l2));
  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode now = head;
    ListNode post = head.next;
    while (true) {
      now.next = pre;
      pre = now;
      now = post;
      if (now == null)
        break;
      post = post.next;
    }
    return pre;
  }

  private void merge(ListNode l1, ListNode l2) {
    ListNode p = l1.next;
    ListNode q = l2.next;
    while (true) {
      l1.next = l2;
      l2.next = p;
      l1 = p;
      l2 = q;
      if (l2 == null)
        break;
      p = p.next;
      q = q.next;
    }
  }
}
