package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }
    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode p = queue.poll();
        if (p.left != null) {
          queue.offer(p.left);
        }
        if (p.right != null) {
          queue.offer(p.right);
        }
        if (i == n - 1) {
          ans.add(p.val);
        }
      }
    }
    return ans;
  }

  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<Integer> ans, TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (level == ans.size()) {
      ans.add(root.val);
    }
    dfs(ans, root.right, level + 1);
    dfs(ans, root.left, level + 1);
  }
}
