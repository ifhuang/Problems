package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/combinations/
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), n, k, 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, List<Integer> pre, int n, int k, int i) {
    if (k == 0) {
      ans.add(pre);
      return;
    }
    for (int j = i + 1; j <= n; j++) {
      List<Integer> cur = new ArrayList<>(pre);
      cur.add(j);
      dfs(ans, cur, n, k - 1, j);
    }
  }

  public List<List<Integer>> combine2(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    if (k == 1)
      for (int i = 1; i <= n; i++) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        ans.add(list);
      }
    else {
      List<List<Integer>> pre = combine(n, k - 1);
      for (List<Integer> list : pre) {
        int last = list.get(list.size() - 1);
        while (last < n) {
          last++;
          List<Integer> copy = new ArrayList<>(list);
          copy.add(last);
          ans.add(copy);
        }
      }
    }
    return ans;
  }

  public List<List<Integer>> combine3(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    backtracking(ans, new ArrayList<>(), n, k, 0);
    return ans;
  }

  private void backtracking(List<List<Integer>> ans, List<Integer> list, int n, int k, int i) {
    if (k == 0) {
      ans.add(new ArrayList<>(list));
      return;
    }
    for (int j = i + 1; j <= n; j++) {
      list.add(j);
      backtracking(ans, list, n, k - 1, j);
      list.remove(list.size() - 1);
    }
  }
}
