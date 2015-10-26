package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    int h = getH(root);
    return h == 0 ? 0 : getH(root.right) == h - 1 ? (1 << (h - 1)) + countNodes(root.right)
        : (1 << (h - 2)) + countNodes(root.left);
  }

  private int getH(TreeNode root) {
    return root == null ? 0 : getH(root.left) + 1;
  }

  public int countNodes2(TreeNode root) {
    int left = leftH(root);
    int right = rightH(root);
    return left == right ? (1 << left) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
  }

  private int leftH(TreeNode root) {
    int d = 0;
    while (root != null) {
      d++;
      root = root.left;
    }
    return d;
  }

  private int rightH(TreeNode root) {
    int d = 0;
    while (root != null) {
      d++;
      root = root.right;
    }
    return d;
  }
}
