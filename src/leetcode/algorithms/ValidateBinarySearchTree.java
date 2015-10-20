package leetcode.algorithms;

import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    TreeNode left = root.left;
    if (left != null) {
      while (left.right != null) {
        left = left.right;
      }
      if (left.val >= root.val) {
        return false;
      }
    }
    TreeNode right = root.right;
    if (right != null) {
      while (right.left != null) {
        right = right.left;
      }
      if (right.val <= root.val) {
        return false;
      }
    }
    return isValidBST(root.left) && isValidBST(root.right);
  }

  public boolean isValidBST2(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    TreeNode pre = null;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (pre != null && cur.val <= pre.val) {
        return false;
      }
      pre = cur;
      cur = cur.right;
    }
    return true;
  }
}
