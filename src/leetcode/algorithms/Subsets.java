package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://oj.leetcode.com/problems/subsets/
public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    dfs(ans, new ArrayList<>(), nums, -1);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, List<Integer> pre, int[] nums, int i) {
    ans.add(pre);
    for (int j = i + 1; j < nums.length; j++) {
      List<Integer> cur = new ArrayList<>(pre);
      cur.add(nums[j]);
      dfs(ans, cur, nums, j);
    }
  }

  public List<List<Integer>> subsets2(int[] S) {
    Arrays.sort(S);
    return subsetsHelper(S, S.length - 1);
  }

  private List<List<Integer>> subsetsHelper(int[] S, int i) {
    List<List<Integer>> ans = new ArrayList<>();
    if (i == 0) {
      List<Integer> list = new ArrayList<>();
      ans.add(list);
      list = new ArrayList<>();
      list.add(S[i]);
      ans.add(list);
    } else {
      List<List<Integer>> pre = subsetsHelper(S, i - 1);
      List<List<Integer>> copy = new ArrayList<>(pre);
      ans.addAll(copy);
      for (List<Integer> list : copy) {
        List<Integer> copy2 = new ArrayList<>(list);
        copy2.add(S[i]);
        ans.add(copy2);
      }
    }
    return ans;
  }

  public List<List<Integer>> subsets3(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    backtracking(ans, new ArrayList<>(), nums, -1);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] nums, int i) {
    ans.add(new ArrayList<>(list));
    for (int j = i + 1; j < nums.length; j++) {
      list.add(nums[j]);
      backtracking(ans, list, nums, j);
      list.remove(list.size() - 1);
    }
  }
}
