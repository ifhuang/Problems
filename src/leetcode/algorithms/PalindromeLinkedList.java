package leetcode.algorithms;

import leetcode.util.ListNode;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head == null)
      return true;
    ListNode p = head;
    ListNode q = head;
    while (q.next != null && q.next.next != null) {
      p = p.next;
      q = q.next.next;
    }
    ListNode post = p.next;
    p.next = null;
    ListNode reversePost = reverse(post);
    while (reversePost != null)
      if (head.val != reversePost.val)
        return false;
      else {
        head = head.next;
        reversePost = reversePost.next;
      }
    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }
}
