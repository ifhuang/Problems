package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/rotate-list/
public class RotateList {
  public ListNode rotateRight(ListNode head, int n) {
    if (head == null)
      return head;
    int len = 1;
    ListNode lastOld = head;
    while (lastOld.next != null) {
      len++;
      lastOld = lastOld.next;
    }
    n = n % len;
    if (n == 0)
      return head;
    int move = len - n;
    ListNode lastNew = head;
    while (move > 1) {
      move--;
      lastNew = lastNew.next;
    }
    ListNode newHead = lastNew.next;
    lastNew.next = null;
    lastOld.next = head;
    return newHead;
  }
}
