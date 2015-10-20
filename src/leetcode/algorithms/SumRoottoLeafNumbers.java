package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRoottoLeafNumbers {
  private int ans;

  public int sumNumbers(TreeNode root) {
    ans = 0;
    helper(root, 0);
    return ans;
  }

  private void helper(TreeNode root, int pre) {
    if (root == null) {
      return;
    }
    pre = pre * 10 + root.val;
    if (root.left == null && root.right == null) {
      ans += pre;
      return;
    }
    helper(root.left, pre);
    helper(root.right, pre);
  }
}
