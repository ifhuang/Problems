package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
  private int ans;

  public int maxPathSum(TreeNode root) {
    ans = Integer.MIN_VALUE;
    helper(root);
    return ans;
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(helper(root.left), 0);
    int right = Math.max(helper(root.right), 0);
    ans = Math.max(ans, left + root.val + right);
    return root.val + Math.max(left, right);
  }
}
