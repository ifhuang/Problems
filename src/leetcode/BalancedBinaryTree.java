package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
  private boolean flag = true;

  public boolean isBalanced(TreeNode root) {
    depth(root);
    return flag;
  }

  private int depth(TreeNode root) {
    if (root == null)
      return 0;
    int l = depth(root.left);
    int r = depth(root.right);
    if (Math.abs(l - r) > 1)
      flag = false;
    return Math.max(l, r) + 1;
  }
}
