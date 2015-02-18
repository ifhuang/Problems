package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        ans.add(root.val);
        stack.push(root);
        root = root.left;
      }
      root = stack.pop().right;
    }
    return ans;
  }
}
