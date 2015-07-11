package leetcode.algorithms;

import leetcode.util.ListNode;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public ListNode reverseList2(ListNode head) {
    return helper(null, head);
  }

  private ListNode helper(ListNode pre, ListNode post) {
    if (post == null)
      return pre;
    ListNode next = post.next;
    post.next = pre;
    pre = post;
    post = next;
    return helper(pre, post);
  }
}
