package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
  private boolean b;

  public boolean isBalanced(TreeNode root) {
    b = true;
    depth(root);
    return b;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    if (b && Math.abs(left - right) > 1) {
      b = false;
    }
    return Math.max(left, right) + 1;
  }
}
