package leetcode.algorithms;

import java.util.List;

// https://oj.leetcode.com/problems/triangle/
public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] pre = new int[n];
    int[] now = null;
    pre[0] = triangle.get(0).get(0);
    if (n == 1) {
      return pre[0];
    }
    for (int i = 1; i < n; i++) {
      now = new int[n];
      now[0] = triangle.get(i).get(0) + pre[0];
      for (int j = 1; j < i; j++) {
        now[j] = triangle.get(i).get(j) + Math.min(pre[j], pre[j - 1]);
      }
      now[i] = triangle.get(i).get(i) + pre[i - 1];
      pre = now;
    }
    int min = now[0];
    for (int i = 1; i < n; i++) {
      min = Math.min(min, now[i]);
    }
    return min;
  }

  public int minimumTotal2(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    dp[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < n; i++) {
      dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
      dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      ans = Math.min(ans, dp[n - 1][i]);
    }
    return ans;
  }
}
