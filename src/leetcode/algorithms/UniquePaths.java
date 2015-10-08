package leetcode.algorithms;

// https://oj.leetcode.com/problems/unique-paths/
public class UniquePaths {
  // time O(m*n), space O(m*n)
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  // time O(m+n), space O(1)
  public int uniquePaths2(int m, int n) {
    if (m > n) {
      return uniquePaths(n, m);
    }
    long m1 = 1;
    for (int i = n; i <= m + n - 2; i++) {
      m1 *= i;
    }
    long m2 = 1;
    for (int i = 1; i <= m - 1; i++) {
      m2 *= i;
    }
    return (int) (m1 / m2);
  }
}
