package leetcode.algorithms;

// https://oj.leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
  // time O(n*m), space O(n*m)
  public boolean isMatch(String s, String p) {
    int n = s.length() + 1;
    int m = p.length() + 1;
    char[] a = s.toCharArray();
    char[] b = p.toCharArray();
    boolean[][] dp = new boolean[n][m];
    dp[0][0] = true;
    for (int i = 2; i < m; i++)
      if (b[i - 1] == '*')
        dp[0][i] = dp[0][i - 2];
    for (int i = 1; i < n; i++)
      for (int j = 1; j < m; j++) {
        if (a[i - 1] == b[j - 1] || b[j - 1] == '.')
          dp[i][j] = dp[i - 1][j - 1];
        else if (b[j - 1] == '*') {
          if (b[j - 2] == a[i - 1] || b[j - 2] == '.')
            dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
          else
            dp[i][j] = dp[i][j - 2];
        }
      }
    return dp[n - 1][m - 1];
  }
}
