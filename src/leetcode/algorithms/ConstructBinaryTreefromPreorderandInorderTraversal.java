package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
  }

  private TreeNode helper(int[] pre, int pi, int pj, int[] in, int ii, int ij) {
    if (pi == pj) {
      return null;
    }
    int i = ii;
    while (i < ij && in[i] != pre[pi]) {
      i++;
    }
    TreeNode root = new TreeNode(pre[pi]);
    root.left = helper(pre, pi + 1, pi + 1 + i - ii, in, ii, i);
    root.right = helper(pre, pi + 1 + i - ii, pj, in, i + 1, ij);
    return root;
  }
}
