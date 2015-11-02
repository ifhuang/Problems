package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
// Given a binary tree, find the length of the longest consecutive sequence path.
// The path refers to any sequence of nodes from some starting node to any node in the tree along
// the parent-child connections. The longest consecutive path need to be from parent to child
// (cannot be the reverse).
public class BinaryTreeLongestConsecutiveSequence {
  private int ans;

  public int longestConsecutive(TreeNode root) {
    ans = 0;
    dfs(root, null, 0);
    return ans;
  }

  private void dfs(TreeNode root, TreeNode pre, int len) {
    if (root == null) {
      return;
    } else if (pre == null) {
      len = 1;
    } else {
      len = root.val == pre.val + 1 ? len + 1 : 1;
    }
    ans = Math.max(ans, len);
    dfs(root.left, root, len);
    dfs(root.right, root, len);
  }
}
