package leetcode.algorithms;

// https://oj.leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
  public int numDistinct(String S, String T) {
    int m = S.length();
    int n = T.length();
    if (m < n)
      return 0;
    int[][] dp = new int[m][n];
    dp[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
    for (int i = 1; i < m; i++)
      dp[i][0] = dp[i - 1][0] + (S.charAt(i) == T.charAt(0) ? 1 : 0);
    for (int i = 1; i < m; i++)
      for (int j = 1; j <= i && j < n; j++)
        dp[i][j] = dp[i - 1][j] + (S.charAt(i) == T.charAt(j) ? dp[i - 1][j - 1] : 0);
    return dp[m - 1][n - 1];
  }
}
