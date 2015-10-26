package leetcode.algorithms;

import leetcode.util.ListNode;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    ListNode q = head;
    while (q != null) {
      if (q.val != val) {
        p.next = q;
        p = p.next;
      }
      q = q.next;
      p.next = null;
    }
    return dummy.next;
  }

}
