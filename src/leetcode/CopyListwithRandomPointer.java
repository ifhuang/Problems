package leetcode;

import leetcode.util.RandomListNode;

// https://oj.leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListwithRandomPointer {
  public RandomListNode copyRandomList(RandomListNode head) {
    return decouple(setRandom(copy(head)));
  }

  private RandomListNode copy(RandomListNode head) {
    RandomListNode p = head;
    while (p != null) {
      RandomListNode copyNode = new RandomListNode(p.label);
      copyNode.next = p.next;
      p.next = copyNode;
      p = copyNode.next;
    }
    return head;
  }

  private RandomListNode setRandom(RandomListNode head) {
    RandomListNode p = head;
    while (p != null) {
      RandomListNode q = p.next;
      if (p.random != null)
        q.random = p.random.next;
      p = p.next.next;
    }
    return head;
  }

  private RandomListNode decouple(RandomListNode head) {
    if (head == null)
      return null;
    RandomListNode newHead = head.next;
    RandomListNode p = head;
    while (p != null) {
      RandomListNode q = p.next;
      p.next = q.next;
      p = p.next;
      if (p != null)
        q.next = p.next;
    }
    return newHead;
  }
}
