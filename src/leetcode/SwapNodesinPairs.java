package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesinPairs {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode p1 = head;
    ListNode p2 = head.next;
    ListNode p3 = head.next.next;
    p2.next = p1;
    p1.next = swapPairs(p3);
    return p2;
  }
}
