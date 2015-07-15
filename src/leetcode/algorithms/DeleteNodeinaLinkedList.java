package leetcode.algorithms;

import leetcode.util.ListNode;

public class DeleteNodeinaLinkedList {
  public void deleteNode(ListNode node) {
    ListNode post = node.next;
    while (true) {
      node.val = post.val;
      if (post.next == null) {
        node.next = null;
        break;
      }
      node = post;
      post = post.next;
    }
  }
}
