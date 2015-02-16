package leetcode;

import leetcode.util.TreeLinkNode;

// https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersinEachNode {
  public void connect(TreeLinkNode root) {
    TreeLinkNode leftMost = root;
    while (leftMost != null) {
      TreeLinkNode now = leftMost;
      while (now != null) {
        if (now.left != null)
          now.left.next = now.right;
        if (now.right != null && now.next != null)
          now.right.next = now.next.left;
        now = now.next;
      }
      leftMost = leftMost.left;
    }
  }
}
