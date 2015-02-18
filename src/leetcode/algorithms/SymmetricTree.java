package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    else if (root.left == null && root.right == null)
      return true;
    else if (root.left == null || root.right == null)
      return false;
    else {
      TreeNode leftTree = new TreeNode(0);
      leftTree.left = root.left.left;
      leftTree.right = root.right.right;
      TreeNode rightTree = new TreeNode(0);
      rightTree.left = root.left.right;
      rightTree.right = root.right.left;
      return root.left.val == root.right.val && isSymmetric(leftTree) && isSymmetric(rightTree);
    }
  }
}
