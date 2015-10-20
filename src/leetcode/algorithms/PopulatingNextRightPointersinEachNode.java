package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeLinkNode;

// https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersinEachNode {
  public void connect(TreeLinkNode root) {
    TreeLinkNode leftMost = root;
    while (leftMost != null) {
      TreeLinkNode now = leftMost;
      while (now != null) {
        if (now.left != null) {
          now.left.next = now.right;
        }
        if (now.right != null && now.next != null) {
          now.right.next = now.next.left;
        }
        now = now.next;
      }
      leftMost = leftMost.left;
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

  public void connect3(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      root.left.next = root.right;
    }
    if (root.right != null && root.next != null) {
      root.right.next = root.next.left;
    }
    connect(root.left);
    connect(root.right);
  }
}
