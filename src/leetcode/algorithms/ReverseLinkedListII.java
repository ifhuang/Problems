package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = head;
    for (int i = 0; i < n - m; i++) {
      p = p.next;
    }
    ListNode pre = dummy;
    ListNode q = head;
    for (int i = 0; i < m - 1; i++) {
      pre = pre.next;
      q = q.next;
      p = p.next;
    }
    while (pre.next != p) {
      pre.next = q.next;
      q.next = p.next;
      p.next = q;
      q = pre.next;
    }
    return dummy.next;
  }

  public ListNode reverseBetween2(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode now = head;
    ListNode post = head.next;
    while (m > 1) {
      m--;
      n--;
      pre = pre.next;
      now = now.next;
      post = post.next;
    }
    while (n > 1) {
      n--;
      ListNode t = post;
      post = post.next;
      t.next = now;
      now = t;
    }
    pre.next.next = post;
    pre.next = now;
    return dummy.next;
  }
}
