package leetcode.algorithms;

// https://oj.leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int a = 0, b = 1;
    for (int i = 0; i < n - 1; i++) {
      dp[i][i] = true;
      dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
      if (dp[i][i + 1]) {
        a = i;
        b = i + 1 + 1;
      }
    }
    dp[n - 1][n - 1] = true;
    for (int diff = 2; diff < n; diff++)
      for (int st = 0; st + diff < n; st++) {
        dp[st][st + diff] = dp[st + 1][st + diff - 1] && s.charAt(st) == s.charAt(st + diff);
        if (dp[st][st + diff]) {
          a = st;
          b = st + diff + 1;
        }
      }
    return s.substring(a, b);
  }
}
