package leetcode.algorithms;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertSortedListtoBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    return helper(head, null);
  }

  private TreeNode helper(ListNode head, ListNode end) {
    if (head == end) {
      return null;
    }
    ListNode p = head;
    ListNode q = head;
    while (q.next != end) {
      p = p.next;
      q = q.next;
      if (q.next == end) {
        break;
      }
      q = q.next;
    }
    TreeNode root = new TreeNode(p.val);
    root.left = helper(head, p);
    root.right = helper(p.next, end);
    return root;
  }
}
