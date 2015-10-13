package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://oj.leetcode.com/problems/subsets-ii/
public class SubsetsII {
  // recursive
  public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    return subsetHelper(num, num.length - 1);
  }

  private List<List<Integer>> subsetHelper(int[] num, int i) {
    Set<List<Integer>> ans = new HashSet<>();
    if (i == 0) {
      List<Integer> list = new ArrayList<>();
      ans.add(list);
      list = new ArrayList<>();
      list.add(num[0]);
      ans.add(list);
    } else {
      List<List<Integer>> pre = subsetHelper(num, i - 1);
      ans.addAll(pre);
      for (List<Integer> list : pre) {
        List<Integer> copy = new ArrayList<>(list);
        copy.add(num[i]);
        ans.add(copy);
      }
    }
    return new ArrayList<>(ans);
  }

  // dfs
  public List<List<Integer>> subsetsWithDup2(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), nums, -1);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, List<Integer> pre, int[] nums, int i) {
    ans.add(pre);
    for (int j = i + 1; j < nums.length; j++) {
      if (j == i + 1 || nums[j] != nums[j - 1]) {
        List<Integer> cur = new ArrayList<>(pre);
        cur.add(nums[j]);
        dfs(ans, cur, nums, j);
      }
    }
  }

  // backtracking
  public List<List<Integer>> subsetsWithDup3(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    backtracking(ans, new ArrayList<>(), nums, -1);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] nums, int i) {
    ans.add(new ArrayList<>(list));
    for (int j = i + 1; j < nums.length; j++) {
      if (j == i + 1 || nums[j] != nums[j - 1]) {
        list.add(nums[j]);
        backtracking(ans, list, nums, j);
        list.remove(list.size() - 1);
      }
    }
  }
}
