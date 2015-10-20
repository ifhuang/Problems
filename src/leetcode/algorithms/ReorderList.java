package leetcode.algorithms;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/reorder-list/
public class ReorderList {
  public void reorderList(ListNode head) {
    ListNode l2 = reverse(split(head));
    ListNode l1 = head;
    merge(l1, l2);
  }

  private ListNode split(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode f = dummy;
    ListNode s = dummy;
    while (s != null && s.next != null) {
      f = f.next;
      s = s.next.next;
    }
    s = f.next;
    f.next = null;
    return s;
  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }
    return pre;
  }

  private void merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    boolean flag = true;
    while (l1 != null || l2 != null) {
      if (flag) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
      flag = !flag;
    }
  }
}
