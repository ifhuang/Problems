package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    int n = s.length();
    List<List<String>> ans = new ArrayList<>();
    if (check(s)) {
      List<String> list = new ArrayList<>();
      list.add(s);
      ans.add(list);
    }
    if (n > 1) {
      for (int i = 1; i < n; i++) {
        String pre = s.substring(0, i);
        String post = s.substring(i);
        if (check(post)) {
          List<List<String>> preAns = partition(pre);
          for (List<String> preList : preAns) {
            List<String> list = new ArrayList<>(preList);
            list.add(post);
            ans.add(list);
          }
        }
      }
    }
    return ans;
  }

  private boolean check(String s) {
    int n = s.length();
    for (int i = 0, j = n - 1; i < j; i++, j--)
      if (s.charAt(i) != s.charAt(j))
        return false;
    return true;
  }

  public List<List<String>> partition2(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }
    for (int i = 0; i < n - 1; i++) {
      dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
    }
    for (int i = 2; i < n; i++) {
      for (int j = 0; j + i < n; j++) {
        dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
      }
    }
    List<List<String>> ans = new ArrayList<>();
    backtracking(ans, new ArrayList<>(), s, n, dp, 0);
    return ans;
  }

  private void backtracking(List<List<String>> ans, List<String> list, String s, int n,
      boolean[][] dp, int i) {
    if (i == n) {
      ans.add(new ArrayList<>(list));
    } else {
      for (int j = i; j < n; j++) {
        if (dp[i][j]) {
          list.add(s.substring(i, j + 1));
          backtracking(ans, list, s, n, dp, j + 1);
          list.remove(list.size() - 1);
        }
      }
    }
  }
}
