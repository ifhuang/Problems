package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/path-sum-ii/
public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), root, sum);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, List<Integer> pre, TreeNode t, int sum) {
    if (t == null) {
      return;
    }
    List<Integer> cur = new ArrayList<>(pre);
    cur.add(t.val);
    sum -= t.val;
    if (t.left == null && t.right == null && sum == 0) {
      ans.add(cur);
    } else {
      dfs(ans, cur, t.left, sum);
      dfs(ans, cur, t.right, sum);
    }
  }
}
