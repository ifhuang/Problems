package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesinPairs {
  // recursive
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode first = head;
    ListNode second = head.next;
    ListNode post = swapPairs(second.next);
    second.next = first;
    first.next = post;
    return second;
  }

  // iterative
  public ListNode swapPairs2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    while (pre.next != null && pre.next.next != null) {
      ListNode first = pre.next;
      ListNode second = first.next;
      ListNode post = second.next;
      pre.next = second;
      second.next = first;
      first.next = post;
      pre = first;
    }
    return dummy.next;
  }
}
