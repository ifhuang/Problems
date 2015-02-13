package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<Item> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(new Item(root, true));
        root = root.left;
      }
      if (stack.peek().f) {
        stack.peek().f = false;
        root = stack.peek().t.right;
      } else
        ans.add(stack.pop().t.val);
    }
    return ans;
  }
}


class Item {
  TreeNode t;
  boolean f;

  Item(TreeNode t, boolean f) {
    this.t = t;
    this.f = f;
  }
}
