package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesinkGroup {
  // recursive
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    int i = 0;
    for (; i < k && p.next != null; i++) {
      p = p.next;
    }
    if (i == k) {
      ListNode post = reverseKGroup(p.next, k);
      p.next = null;
      ListNode newHead = reverse(head);
      head.next = post;
      return newHead;
    } else {
      return head;
    }
  }

  private ListNode reverse(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode post = head.next;
    ListNode pre = reverse(post);
    if (pre == null) {
      return head;
    }
    post.next = head;
    return pre;
  }

  // iterative
  public ListNode reverseKGroup2(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    ListNode q = dummy;
    while (true) {
      int i = 0;
      for (; i < k && q.next != null; i++) {
        q = q.next;
      }
      if (i == k) {
        ListNode post = q.next;
        q.next = null;
        ListNode newHead = reverse2(p.next);
        q = p.next;
        q.next = post;
        p.next = newHead;
        p = q;
      } else {
        break;
      }
    }
    return dummy.next;
  }

  private ListNode reverse2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null;
    ListNode cur = head;
    ListNode post = head.next;
    while (true) {
      cur.next = pre;
      pre = cur;
      cur = post;
      if (cur == null) {
        break;
      }
      post = post.next;
    }
    return pre;
  }
}
