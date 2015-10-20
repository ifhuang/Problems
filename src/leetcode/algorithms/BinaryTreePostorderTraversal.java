package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
  class Item {
    TreeNode node;
    boolean flag;

    public Item(TreeNode node, boolean flag) {
      this.node = node;
      this.flag = flag;
    }
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    Stack<Item> stack = new Stack<>();
    TreeNode p = root;
    List<Integer> ans = new ArrayList<>();
    while (!stack.isEmpty() || p != null) {
      while (p != null) {
        stack.push(new Item(p, true));
        p = p.left;
      }
      Item item = stack.pop();
      if (item.flag) {
        item.flag = false;
        stack.push(item);
        p = item.node.right;
      } else {
        ans.add(item.node.val);
      }
    }
    return ans;
  }

  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(ans, root);
    return ans;
  }

  private void helper(List<Integer> ans, TreeNode root) {
    if (root == null) {
      return;
    }
    helper(ans, root.left);
    helper(ans, root.right);
    ans.add(root.val);
  }
}
