package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

  // recursion
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbersHelper(l1, l2, 0);
  }

  private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int flag) {
    if (l1 == null && l2 == null && flag == 0)
      return null;
    int sum = flag;
    if (l1 != null) {
      sum += l1.val;
      l1 = l1.next;
    }
    if (l2 != null) {
      sum += l2.val;
      l2 = l2.next;
    }
    ListNode node = new ListNode(sum % 10);
    node.next = addTwoNumbersHelper(l1, l2, sum / 10);
    return node;
  }

  // iteration
  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode now = dummy;
    int sum = 0;
    while (l1 != null || l2 != null || sum != 0) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      now.next = new ListNode(sum % 10);
      now = now.next;
      sum /= 10;
    }
    return dummy.next;
  }
}
