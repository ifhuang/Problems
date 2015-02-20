package leetcode.algorithms;

import leetcode.util.ListNode;

public class IntersectionofTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;
    ListNode pA = headA;
    ListNode pB = headB;
    int a = 0;
    int b = 0;
    while (pA.next != null || pB.next != null) {
      if (pA.next != null) {
        pA = pA.next;
        a++;
      }
      if (pB.next != null) {
        pB = pB.next;
        b++;
      }
    }
    if (pA != pB)
      return null;
    pA = headA;
    pB = headB;
    int d = a - b;
    while (d != 0)
      if (d < 0) {
        pB = pB.next;
        d++;
      } else {
        pA = pA.next;
        d--;
      }
    while (pA != pB) {
      pA = pA.next;
      pB = pB.next;
    }
    return pA;
  }
}
