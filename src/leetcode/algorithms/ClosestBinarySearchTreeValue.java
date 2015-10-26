package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/closest-binary-search-tree-value/
// Given a non-empty binary search tree and a target value, find the value in the BST that is
// closest to the target.
// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
public class ClosestBinarySearchTreeValue {
  public int closestValue(TreeNode root, double target) {
    int a = root.val;
    TreeNode kid = target < a ? root.left : root.right;
    if (kid == null) {
      return a;
    }
    int b = closestValue(kid, target);
    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
  }
}
