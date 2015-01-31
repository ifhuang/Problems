package leetcode;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRoottoLeafNumbers {
  private int ans;

  public int sumNumbers(TreeNode root) {
    ans = 0;
    helper(root);
    return ans;
  }

  private void helper(TreeNode root) {
    if (root == null)
      return;
    if (root.left == null && root.right == null)
      ans += root.val;
    if (root.left != null) {
      root.left.val += root.val * 10;
      helper(root.left);
    }
    if (root.right != null) {
      root.right.val += root.val * 10;
      helper(root.right);
    }
  }
}
