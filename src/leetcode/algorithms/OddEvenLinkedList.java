package leetcode.algorithms;

import leetcode.util.ListNode;

// https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode oddHead = odd;
    ListNode evenHead = even;
    ListNode p = head.next.next;
    boolean flag = true;
    while (p != null) {
      if (flag) {
        odd.next = p;
        odd = odd.next;
      } else {
        even.next = p;
        even = even.next;
      }
      flag = !flag;
      p = p.next;
    }
    even.next = null;
    odd.next = evenHead;
    return oddHead;
  }
}
