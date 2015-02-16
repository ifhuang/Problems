package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    while (true) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (stack.isEmpty())
        break;
      p = stack.pop();
      ans.add(p.val);
      p = p.right;
    }
    return ans;
  }
}
