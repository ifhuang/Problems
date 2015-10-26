package leetcode.algorithms;

// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) {
      return 0;
    }
    int n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];
    int ans = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] =
            matrix[i - 1][j - 1] == '0' ? 0 : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                dp[i - 1][j - 1]) + 1;
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans * ans;
  }
}
