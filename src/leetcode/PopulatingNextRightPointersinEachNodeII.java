package leetcode;

import leetcode.util.TreeLinkNode;

// https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersinEachNodeII {
  public void connect(TreeLinkNode root) {
    TreeLinkNode pre = null;
    TreeLinkNode now = root;
    TreeLinkNode leftMost = null;
    while (now != null) {
      while (now != null) {
        if (now.left != null) {
          if (pre == null)
            leftMost = now.left;
          else
            pre.next = now.left;
          pre = now.left;
        }
        if (now.right != null) {
          if (pre == null)
            leftMost = now.right;
          else
            pre.next = now.right;
          pre = now.right;
        }
        now = now.next;
      }
      pre = null;
      now = leftMost;
      leftMost = null;
    }
  }
}
