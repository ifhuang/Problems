package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreetoLinkedList {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode q = root.right;
    root.right = root.left;
    root.left = null;
    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = q;
    flatten(root.right);
  }
}
