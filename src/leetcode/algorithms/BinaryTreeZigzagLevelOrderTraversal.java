package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean flag = false;
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
      if (flag) {
        Collections.reverse(list);
      }
      flag = !flag;
      ans.add(list);
    }
    return ans;
  }

  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, root, 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, TreeNode cur, int level) {
    if (cur == null) {
      return;
    }
    if (ans.size() <= level) {
      List<Integer> list = new LinkedList<>();
      ans.add(list);
    }
    List<Integer> list = ans.get(level);
    if (level % 2 == 0) {
      list.add(cur.val);
    } else {
      list.add(0, cur.val);
    }
    dfs(ans, cur.left, level + 1);
    dfs(ans, cur.right, level + 1);
  }
}
