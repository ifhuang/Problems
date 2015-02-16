package leetcode;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/partition-list/
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode insertPre = dummy;
    ListNode pre = dummy;
    ListNode now = dummy.next;
    while (now != null)
      if (now.val >= x) {
        pre = now;
        now = now.next;
      } else if (insertPre == pre) {
        insertPre = pre = now;
        now = now.next;
      } else {
        pre.next = now.next;
        now.next = insertPre.next;
        insertPre.next = now;
        insertPre = insertPre.next;
        now = pre.next;
      }
    return dummy.next;
  }
}
