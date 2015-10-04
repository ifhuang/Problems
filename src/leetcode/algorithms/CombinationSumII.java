package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
  // dfs with set
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(candidates);
    dfs(set, new ArrayList<>(), candidates, target, 0);
    return new ArrayList<>(set);
  }

  private void dfs(Set<List<Integer>> set, List<Integer> pre, int[] candidates, int target,
      int start) {
    if (target == 0) {
      set.add(pre);
    } else if (target > 0) {
      for (int i = start; i < candidates.length; i++) {
        List<Integer> pre2 = new ArrayList<>(pre);
        pre2.add(candidates[i]);
        dfs(set, pre2, candidates, target - candidates[i], i + 1);
      }
    }
  }

  // dfs without set
  public List<List<Integer>> combinationSum22(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    dfs2(ans, new ArrayList<>(), candidates, target, -1);
    return ans;
  }

  private void dfs2(List<List<Integer>> ans, List<Integer> pre, int[] candidates, int target, int i) {
    if (target == 0) {
      ans.add(pre);
    } else if (target > 0) {
      int p = 0;
      for (int j = i + 1; j < candidates.length; j++) {
        if (candidates[j] != p) {
          p = candidates[j];
          List<Integer> cur = new ArrayList<>(pre);
          cur.add(candidates[j]);
          dfs2(ans, cur, candidates, target - candidates[j], j);
        }
      }
    }
  }
}
