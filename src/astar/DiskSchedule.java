package astar;

import java.util.Scanner;

public class DiskSchedule {
  private static int points[][] = new int[1024][2];
  private static int dis[][] = new int[1024][1024];
  private static int dp[][] = new int[1024][1024];

  private static int cal_cycle_dis(int a, int b) {

    if (a > b) {
      return Math.min(a - b, b + 360 - a);
    }
    return Math.min(b - a, a + 360 - b);
  }

  private static int run(int n) {
    // calculate the distance for each two data
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        dis[i][j] =
            dis[j][i] =
                (points[j][0] - points[i][0]) * 400 + cal_cycle_dis(points[i][1], points[j][1]);
      }
    }

    // run the dp
    dp[0][1] = dis[0][1];
    for (int j = 2; j < n; j++) {
      for (int i = 0; i < j - 1; i++) {
        dp[i][j] = dp[i][j - 1] + dis[j - 1][j];
      }
      int mini = Integer.MAX_VALUE;
      for (int k = 0; k < j - 1; k++) {
        mini = Math.min(mini, dp[k][j - 1] + dis[k][j]);
      }
      dp[j - 1][j] = mini;
    }
    dp[n - 1][n - 1] = dp[n - 2][n - 1] + dis[n - 2][n - 1];
    // return the dp result plus the reading time
    return dp[n - 1][n - 1] + 10 * (n - 1);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    while (m-- > 0) {
      // read data of the case
      int n = scanner.nextInt();
      for (int i = 1; i <= n; i++) {
        points[i][0] = scanner.nextInt();
        points[i][1] = scanner.nextInt();
      }
      // initial the first data and reset the number of the data
      points[0][0] = points[0][1] = 0;
      ++n;
      System.out.println(run(n) + "");
    }
    scanner.close();
  }
}
