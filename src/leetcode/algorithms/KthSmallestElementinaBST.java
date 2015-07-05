package leetcode.algorithms;

import leetcode.util.TreeNode;

public class KthSmallestElementinaBST {
  private int i = 0;
  private int ans = 0;

  public int kthSmallest(TreeNode root, int k) {
    search(root, k);
    return ans;
  }

  private void search(TreeNode root, int k) {
    if (root == null)
      return;
    search(root.left, k);
    i++;
    if (i == k)
      ans = root.val;
    search(root.right, k);
  }
}
