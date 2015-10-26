package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/count-univalue-subtrees/
// Given a binary tree, count the number of uni-value subtrees.
// A Uni-value subtree means all nodes of the subtree have the same value.
public class CountUnivalueSubtrees {
  private int count;

  public int countUnivalSubtrees(TreeNode root) {
    count = 0;
    helper(root);
    return count;
  }

  private boolean helper(TreeNode node) {
    if (node == null) {
      return true;
    }
    boolean left = helper(node.left);
    boolean right = helper(node.right);
    if (left && right) {
      if (node.left != null && node.val != node.left.val) {
        return false;
      }
      if (node.right != null && node.val != node.right.val) {
        return false;
      }
      count++;
      return true;
    }
    return false;
  }
}
