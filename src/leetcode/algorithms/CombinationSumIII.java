package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    backtracking(ans, new ArrayList<>(), 0, k, n, 0);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, List<Integer> list, int start, int k, int n,
      int sum) {
    if (list.size() == k) {
      if (sum == n)
        ans.add(new ArrayList<>(list));
    } else {
      for (int i = start + 1; i <= 9; i++) {
        list.add(i);
        sum += i;
        backtracking(ans, list, i, k, n, sum);
        list.remove(list.size() - 1);
        sum -= i;
      }
    }
  }
}
