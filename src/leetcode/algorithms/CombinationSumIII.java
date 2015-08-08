package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    search(ans, new ArrayList<>(), 0, k, n);
    return ans;
  }

  private void search(List<List<Integer>> ans, List<Integer> pre, int start, int k, int n) {
    if (pre.size() > k)
      return;
    else if (pre.size() == k) {
      if (sum(pre) == n)
        ans.add(pre);
    } else {
      for (int i = start + 1; i <= 9; i++) {
        List<Integer> now = new ArrayList<>(pre);
        now.add(i);
        search(ans, now, i, k, n);
      }
    }
  }

  private int sum(List<Integer> list) {
    int t = 0;
    for (int i : list)
      t += i;
    return t;
  }
}
