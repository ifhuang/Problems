package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTreeHelper(int[] preorder, int prestart, int preend, int[] inorder,
      int instart, int inend) {
    if (prestart > preend)
      return null;
    TreeNode root = new TreeNode(preorder[prestart]);
    int index = instart;
    for (; index <= inend; index++)
      if (inorder[index] == root.val)
        break;
    root.left =
        buildTreeHelper(preorder, prestart + 1, prestart + index - instart, inorder, instart,
            index - 1);
    root.right =
        buildTreeHelper(preorder, prestart + index - instart + 1, preend, inorder, index + 1, inend);
    return root;
  }
}
