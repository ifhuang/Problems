package other;

// [8, 4, 7]
// [6, 5, 9].
// path£º
// 8-4-7-9 min: 4
// 8-4-5-9 min: 4
// 8-6-5-9 min: 5
// return: 5
public class MaximumMinimumPath {
  public int solve(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = matrix[0][0];
    for (int i = 1; i < m; i++) {
      dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
    }
    for (int j = 1; j < n; j++) {
      dp[0][j] = Math.min(dp[0][j - 1], matrix[0][j]);
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] =
            Math.max(Math.min(dp[i - 1][j], matrix[i][j]), Math.min(dp[i][j - 1], matrix[i][j]));
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    MaximumMinimumPath m = new MaximumMinimumPath();
    int[][] matrix = { {8, 3, 7}, {6, 5, 4}};
    System.out.println(m.solve(matrix));
  }
}
