package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    } else if (root.left == null && root.right == null) {
      return true;
    } else if (root.left == null || root.right == null) {
      return false;
    } else if (root.left.val != root.right.val) {
      return false;
    } else {
      TreeNode r1 = new TreeNode(0);
      r1.left = root.left.left;
      r1.right = root.right.right;
      TreeNode r2 = new TreeNode(0);
      r2.left = root.left.right;
      r2.right = root.right.left;
      return isSymmetric(r1) && isSymmetric(r2);
    }
  }

  public boolean isSymmetric2(TreeNode root) {
    return root == null ? true : helper(root.left, root.right);
  }

  private boolean helper(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    } else if (t1 == null || t2 == null) {
      return false;
    } else {
      return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
  }

  public boolean isSymmetric3(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root.left);
    queue.offer(root.right);
    while (!queue.isEmpty()) {
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();
      if (t1 == null && t2 == null) {
      } else if (t1 == null || t2 == null) {
        return false;
      } else if (t1.val != t2.val) {
        return false;
      } else {
        queue.offer(t1.left);
        queue.offer(t2.right);
        queue.offer(t1.right);
        queue.offer(t2.left);
      }
    }
    return true;
  }
}
