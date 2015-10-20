package leetcode.algorithms;

// https://oj.leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    if (m < n) {
      return 0;
    }
    int[][] dp = new int[m][n];
    dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + (s.charAt(i) == t.charAt(0) ? 1 : 0);
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n && j <= i; j++) {
        dp[i][j] = dp[i - 1][j] + (s.charAt(i) == t.charAt(j) ? dp[i - 1][j - 1] : 0);
      }
    }
    return dp[m - 1][n - 1];
  }
}
