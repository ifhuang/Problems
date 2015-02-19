package codeforces;

import java.io.PrintStream;
import java.util.Scanner;

public class Theleastroundway {

  static int count(int n, int f) {
    if (n == 0)
      return 1;
    int count = 0;
    while (n % f == 0) {
      n /= f;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintStream ps = new PrintStream(System.out);
    int n = scanner.nextInt();
    int[][] matrix = new int[n][n];
    int[][][] dp = new int[n][n][2];
    boolean zero = false;
    int zeroX = -1;
    int zeroY = -1;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scanner.nextInt();
        if (!zero && matrix[i][j] == 0) {
          zero = true;
          zeroX = i;
          zeroY = j;
        }
        dp[i][j][0] = count(matrix[i][j], 2);
        dp[i][j][1] = count(matrix[i][j], 5);
      }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        for (int k = 0; k < 2; k++)
          if (i == 0 && j == 0)
            ;
          else if (i == 0)
            dp[i][j][k] += dp[i][j - 1][k];
          else if (j == 0)
            dp[i][j][k] += dp[i - 1][j][k];
          else
            dp[i][j][k] += Math.min(dp[i][j - 1][k], dp[i - 1][j][k]);
    int ans = Math.min(dp[n - 1][n - 1][0], dp[n - 1][n - 1][1]);
    if (zero && ans > 1) {
      ps.println(1);
      int x = 0;
      int y = 0;
      while (x++ < zeroX)
        ps.print('D');
      while (y++ < zeroY)
        ps.print('R');
      while (x++ < n)
        ps.print('D');
      while (y++ < n)
        ps.print('R');
      ps.println();
    } else {
      ps.println(ans);
      StringBuilder sb = new StringBuilder();
      int x = n - 1;
      int y = n - 1;
      int t = dp[x][y][0] < dp[x][y][1] ? 0 : 1;
      while (x > 0 || y > 0)
        if (y == 0) {
          sb.append('D');
          x--;
        } else if (x == 0) {
          sb.append('R');
          y--;
        } else if (dp[x - 1][y][t] < dp[x][y - 1][t]) {
          sb.append('D');
          x--;
        } else {
          sb.append('R');
          y--;
        }
      ps.println(sb.reverse().toString());
    }
    ps.close();
    scanner.close();
  }
}
