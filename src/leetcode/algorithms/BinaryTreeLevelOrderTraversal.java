package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode t = queue.poll();
        list.add(t.val);
        if (t.left != null) {
          queue.offer(t.left);
        }
        if (t.right != null) {
          queue.offer(t.right);
        }
      }
      ans.add(list);
    }
    return ans;
  }
}
