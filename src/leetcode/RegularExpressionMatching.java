package leetcode;

// https://oj.leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    int sL = s.length();
    int pL = p.length();
    boolean[][] dp = new boolean[sL + 1][pL + 1];
    dp[0][0] = true;
    for (int i = 1; i < sL + 1; i++)
      dp[i][0] = false;
    for (int i = 2; i < pL + 1; i++)
      if (p.charAt(i - 1) == '*')
        dp[0][i] = dp[0][i - 2];
    for (int i = 1; i < sL + 1; i++)
      for (int j = 1; j < pL + 1; j++)
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
          dp[i][j] = dp[i - 1][j - 1];
        else if (p.charAt(j - 1) == '*') {
          if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
          else
            dp[i][j] = dp[i][j - 2];
        }
    return dp[sL][pL];
  }
}
