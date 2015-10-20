package leetcode.algorithms;

import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTree {
  // iterative
  public void recoverTree(TreeNode root) {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    TreeNode cur = root;
    Stack<TreeNode> stack = new Stack<>();
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (pre != null && cur.val <= pre.val) {
        if (first == null) {
          first = pre;
          second = cur;
        } else {
          second = cur;
        }
      }
      pre = cur;
      cur = cur.right;
    }
    int t = first.val;
    first.val = second.val;
    second.val = t;
  }

  private TreeNode pre;
  private TreeNode first;
  private TreeNode second;

  // recursive
  public void recoverTree2(TreeNode root) {
    pre = null;
    first = null;
    second = null;
    dfs(root);
    int t = first.val;
    first.val = second.val;
    second.val = t;
  }

  private void dfs(TreeNode cur) {
    if (cur == null) {
      return;
    }
    dfs(cur.left);
    if (pre != null && pre.val >= cur.val) {
      if (first == null) {
        first = pre;
        second = cur;
      } else {
        second = cur;
      }
    }
    pre = cur;
    dfs(cur.right);
  }
}
