package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreefromInorderandPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode buildTreeHelper(int[] inorder, int instart, int inend, int[] postorder,
      int poststart, int postend) {
    if (poststart > postend)
      return null;
    TreeNode root = new TreeNode(postorder[postend]);
    int index = instart;
    for (; index <= inend; index++)
      if (inorder[index] == root.val)
        break;
    root.left =
        buildTreeHelper(inorder, instart, index - 1, postorder, poststart, poststart + index
            - instart - 1);
    root.right =
        buildTreeHelper(inorder, index + 1, inend, postorder, poststart + index - instart,
            postend - 1);
    return root;
  }
}
