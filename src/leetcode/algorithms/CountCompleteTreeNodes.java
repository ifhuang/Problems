package leetcode.algorithms;

import leetcode.util.TreeNode;

public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    int h = getH(root);
    return h == 0 ? 0 : getH(root.right) == h - 1 ? (1 << (h - 1)) + countNodes(root.right)
        : (1 << (h - 2)) + countNodes(root.left);
  }

  private int getH(TreeNode root) {
    return root == null ? 0 : getH(root.left) + 1;
  }
}
