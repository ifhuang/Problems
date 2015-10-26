package leetcode.algorithms;

import leetcode.util.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
  // iterative
  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }
    return pre;
  }

  // recursive
  public ListNode reverseList2(ListNode head) {
    return helper(null, head);
  }

  private ListNode helper(ListNode pre, ListNode cur) {
    if (cur == null) {
      return pre;
    }
    ListNode post = cur.next;
    cur.next = pre;
    pre = cur;
    cur = post;
    return helper(pre, cur);
  }
}
