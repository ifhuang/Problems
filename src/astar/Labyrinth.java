package astar;

import java.util.Scanner;

public class Labyrinth {
  private static int m;
  private static int n;
  private static int[][] data;
  private static int[][][] dp;
  private static boolean[][][] flag;

  private static int dp(int i, int j, int k) {
    if (i == -1 || i == m || j == -1) {
      return Integer.MIN_VALUE;
    }

    if (flag[i][j][k])
      return dp[i][j][k];
    flag[i][j][k] = true;
    if (k == 0) {
      dp[i][j][k] = Math.max(dp(i, j - 1, 0), dp(i, j - 1, 1));
      dp[i][j][k] = Math.max(dp(i - 1, j, 0), dp[i][j][k]);
      dp[i][j][k] += data[i][j];
    } else {
      dp[i][j][k] = Math.max(dp(i, j - 1, 0), dp(i, j - 1, 1));
      dp[i][j][k] = Math.max(dp(i + 1, j, 1), dp[i][j][k]);
      dp[i][j][k] += data[i][j];
    }
    return dp[i][j][k];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int k = 1;
    while (T-- > 0) {
      m = scanner.nextInt();
      n = scanner.nextInt();
      data = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          data[i][j] = scanner.nextInt();
        }
      }
      flag = new boolean[m][n][2];
      dp = new int[m][n][2];
      flag[0][0][0] = flag[0][0][1] = true;
      dp[0][0][0] = dp[0][0][1] = data[0][0];
      int result = Math.max(dp(0, n - 1, 0), dp(0, n - 1, 1));
      System.out.println(String.format("Case #%d:\n%d", k++, result));
    }
    scanner.close();
  }
}
