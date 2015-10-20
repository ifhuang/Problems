package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthofBinaryTree {
  public int maxDepth(TreeNode root) {
    return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public int maxDepth2(TreeNode root) {
    int ans = 0;
    if (root == null) {
      return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      ans++;
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode t = queue.poll();
        if (t.left != null) {
          queue.offer(t.left);
        }
        if (t.right != null) {
          queue.offer(t.right);
        }
      }
    }
    return ans;
  }
}
