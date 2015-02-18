package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/path-sum/
public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false;
    else if (root.left == null && root.right == null)
      return root.val == sum;
    else {
      int newSum = sum - root.val;
      return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
  }
}
