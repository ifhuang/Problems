package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

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
          if (pre == null) {
            leftMost = now.left;
          } else {
            pre.next = now.left;
          }
          pre = now.left;
        }
        if (now.right != null) {
          if (pre == null) {
            leftMost = now.right;
          } else {
            pre.next = now.right;
          }
          pre = now.right;
        }
        now = now.next;
      }
      pre = null;
      now = leftMost;
      leftMost = null;
    }
  }

  public void connect2(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeLinkNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeLinkNode t = queue.poll();
        if (i != n - 1) {
          t.next = queue.peek();
        }
        if (t.left != null) {
          queue.offer(t.left);
        }
        if (t.right != null) {
          queue.offer(t.right);
        }
      }
    }
  }
}
