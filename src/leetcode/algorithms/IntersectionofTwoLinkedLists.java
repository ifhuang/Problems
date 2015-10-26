package leetcode.algorithms;

import leetcode.util.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionofTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pA = headA;
    ListNode pB = headB;
    int a = 0;
    int b = 0;
    while (pA.next != null) {
      pA = pA.next;
      a++;
    }
    while (pB.next != null) {
      pB = pB.next;
      b++;
    }
    if (pA != pB) {
      return null;
    }
    pA = headA;
    pB = headB;
    int d = a - b;
    while (d < 0) {
      pB = pB.next;
      d++;
    }
    while (d > 0) {
      pA = pA.next;
      d--;
    }
    while (pA != pB) {
      pA = pA.next;
      pB = pB.next;
    }
    return pA;
  }

  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }
}
