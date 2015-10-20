package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
  // recursive
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(root, ans);
    return ans;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    helper(root.left, list);
    list.add(root.val);
    helper(root.right, list);
  }

  // iterative
  public List<Integer> inorderTraversal2(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    List<Integer> ans = new ArrayList<>();
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      ans.add(cur.val);
      cur = cur.right;
    }
    return ans;
  }
}
