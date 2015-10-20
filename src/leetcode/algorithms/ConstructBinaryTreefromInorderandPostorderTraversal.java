package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreefromInorderandPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }

  private TreeNode helper(int[] in, int ii, int ij, int[] post, int pi, int pj) {
    if (ii == ij) {
      return null;
    }
    int i = ii;
    while (i < ij && in[i] != post[pj - 1]) {
      i++;
    }
    TreeNode root = new TreeNode(post[pj - 1]);
    root.left = helper(in, ii, i, post, pi, pi + i - ii);
    root.right = helper(in, i + 1, ij, post, pi + i - ii, pj - 1);
    return root;
  }
}
