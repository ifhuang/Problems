package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.util.ListNode;

// https://oj.leetcode.com/problems/merge-k-sorted-lists/
public class MergekSortedLists {
  // time O(n*log(k)), space O(1)
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(0);
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        return l1.val - l2.val;
      }
    });
    for (ListNode ln : lists) {
      if (ln != null) {
        pq.offer(ln);
      }
    }
    ListNode p = dummy;
    while (!pq.isEmpty()) {
      p.next = pq.poll();
      p = p.next;
      if (p.next != null) {
        pq.offer(p.next);
      }
    }
    return dummy.next;
  }
}
