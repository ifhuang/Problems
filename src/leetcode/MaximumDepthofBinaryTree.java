package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthofBinaryTree {
  public int maxDepth(TreeNode root) {
    return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
