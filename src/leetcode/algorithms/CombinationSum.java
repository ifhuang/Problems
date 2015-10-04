package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// https://oj.leetcode.com/problems/combination-sum/
public class CombinationSum {
  // dfs with set
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(candidates);
    dfs(set, new ArrayList<>(), candidates, target, 0);
    return new ArrayList<>(set);
  }

  private void dfs(Set<List<Integer>> set, List<Integer> pre, int[] candidates, int target, int i) {
    if (target == 0) {
      set.add(pre);
    } else if (target > 0) {
      for (int j = i; j < candidates.length; j++) {
        List<Integer> cur = new ArrayList<>(pre);
        cur.add(candidates[j]);
        dfs(set, cur, candidates, target - candidates[j], j);
      }
    }
  }

  // dfs without set
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    dfs2(ans, new ArrayList<>(), candidates, target, 0);
    return ans;
  }

  private void dfs2(List<List<Integer>> ans, List<Integer> pre, int[] candidates, int target, int i) {
    if (target == 0) {
      ans.add(pre);
    } else if (target > 0) {
      int p = 0;
      for (int j = i; j < candidates.length; j++) {
        if (candidates[j] != p) {
          p = candidates[j];
          List<Integer> cur = new ArrayList<>(pre);
          cur.add(candidates[j]);
          dfs2(ans, cur, candidates, target - candidates[j], j);
        }
      }
    }
  }

  // backtracking
  public List<List<Integer>> combinationSum3(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    backtracking(ans, new Stack<>(), candidates, target, 0);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, Stack<Integer> stack, int[] candidates,
      int target, int i) {
    if (target == 0) {
      ans.add(new ArrayList<>(stack));
    } else if (target > 0) {
      int p = 0;
      for (int j = i; j < candidates.length; j++) {
        if (candidates[j] != p) {
          p = candidates[j];
          stack.push(candidates[j]);
          backtracking(ans, stack, candidates, target - candidates[j], j);
          stack.pop();
        }
      }
    }
  }
}
