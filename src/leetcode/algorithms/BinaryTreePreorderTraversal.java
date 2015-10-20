package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    List<Integer> ans = new ArrayList<>();
    while (!stack.isEmpty() || p != null) {
      while (p != null) {
        ans.add(p.val);
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      p = p.right;
    }
    return ans;
  }

  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(ans, root);
    return ans;
  }

  private void helper(List<Integer> ans, TreeNode root) {
    if (root == null) {
      return;
    }
    ans.add(root.val);
    helper(ans, root.left);
    helper(ans, root.right);
  }
}
