package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArraytoBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int i, int j) {
    if (i > j) {
      return null;
    }
    int mid = (i + j) >>> 1;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, i, mid - 1);
    root.right = helper(nums, mid + 1, j);
    return root;
  }
}
