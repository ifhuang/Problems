package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addHelper(l1, l2, 0);
  }

  private ListNode addHelper(ListNode l1, ListNode l2, int x) {
    if (l1 == null && l2 == null && x == 0)
      return null;
    else if (l1 == null && l2 == null && x == 1)
      return new ListNode(x);
    else {
      int val = x;
      ListNode l1n = null;
      if (l1 != null) {
        val += l1.val;
        l1n = l1.next;
      }
      ListNode l2n = null;
      if (l2 != null) {
        val += l2.val;
        l2n = l2.next;
      }
      ListNode ln = new ListNode(val % 10);
      ln.next = addHelper(l1n, l2n, val / 10);
      return ln;
    }
  }
}
