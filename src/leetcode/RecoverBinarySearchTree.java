package leetcode;

import java.util.Stack;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTree {
  private TreeNode firstNode;
  private TreeNode secondNode;

  public void recoverTree(TreeNode root) {
    inOrderFind(root);
    int t = firstNode.val;
    firstNode.val = secondNode.val;
    secondNode.val = t;
  }

  private void inOrderFind(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    boolean first = true;
    TreeNode pre = null;
    while (true) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (stack.isEmpty())
        break;
      p = stack.pop();
      if (first) {
        first = false;
        pre = p;
      } else if (pre.val > p.val)
        if (firstNode == null) {
          firstNode = pre;
          secondNode = p;
        } else {
          secondNode = p;
          break;
        }
      pre = p;
      p = p.right;
    }
  }
}
