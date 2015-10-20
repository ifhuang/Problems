package leetcode.algorithms;

// https://oj.leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {
  public int minCut(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }
    for (int i = 0; i < n - 1; i++) {
      dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
    }
    for (int i = 2; i < n; i++) {
      for (int j = 0; j + i < n; j++) {
        dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
      }
    }
    int[] min = new int[n];
    for (int i = 1; i < n; i++) {
      if (!dp[0][i]) {
        for (int j = 0; j < i; j++) {
          if (dp[j + 1][i]) {
            min[i] = Math.min(min[i], min[j] + 1);
          }
        }
      }
    }
    return min[n - 1];
  }
}
