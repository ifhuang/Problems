package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> ans = new HashSet<>();
    Arrays.sort(candidates);
    search(candidates, target, 0, ans, new ArrayList<Integer>());
    return new ArrayList<>(ans);
  }

  private void search(int[] candidates, int target, int start, Set<List<Integer>> ans,
      List<Integer> pre) {
    if (target < 0)
      return;
    else if (target == 0)
      ans.add(pre);
    else
      for (int i = start; i < candidates.length; i++) {
        List<Integer> pre2 = new ArrayList<>(pre);
        pre2.add(candidates[i]);
        search(candidates, target - candidates[i], i + 1, ans, pre2);
      }
  }
}
