package leetcode.algorithms;

import leetcode.util.TreeNode;

public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    TreeNode newRoot = new TreeNode(root.val);
    newRoot.left = invertTree(root.right);
    newRoot.right = invertTree(root.left);
    return newRoot;
  }
}
