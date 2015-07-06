package leetcode.algorithms;

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    if (n == 0)
      return 0;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++)
      dp[i][0] = matrix[i][0] - '0';
    for (int j = 0; j < m; j++)
      dp[0][j] = matrix[0][j] - '0';
    for (int i = 1; i < n; i++)
      for (int j = 1; j < m; j++)
        dp[i][j] =
            matrix[i][j] == '0' ? 0 : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                dp[i - 1][j - 1]) + 1;
    int ans = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        ans = Math.max(ans, dp[i][j]);
    return ans * ans;
  }
}
