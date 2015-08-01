package leetcode.algorithms;

import java.util.Stack;

import leetcode.util.TreeNode;

public class BinarySearchTreeIterator {

  private Stack<TreeNode> stack;

  public BinarySearchTreeIterator(TreeNode root) {
    stack = new Stack<>();
    push(root);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pop();
    push(node.right);
    return node.val;
  }

  private void push(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }
}
