package leetcode.algorithms;

// https://oj.leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
  // time O(n^2), space O(n^2)
  public String longestPalindrome(String s) {
    int n = s.length();
    char[] c = s.toCharArray();
    boolean[][] dp = new boolean[n][n];
    int start = 0, end = 1;
    for (int i = 0; i < n; i++)
      dp[i][i] = true;
    for (int i = 0; i < n - 1; i++) {
      if (c[i] == c[i + 1]) {
        dp[i][i + 1] = true;
        start = i;
        end = i + 2;
      }
    }
    for (int diff = 2; diff < n; diff++) {
      for (int i = 0; i + diff < n; i++) {
        if (dp[i + 1][i + diff - 1] && c[i] == c[i + diff]) {
          dp[i][i + diff] = true;
          start = i;
          end = i + diff + 1;
        }
      }
    }
    return s.substring(start, end);
  }

  // time O(n^2), space O(n) ?
  public String longestPalindrome2(String s) {
    int n = s.length();
    char[] c = s.toCharArray();
    boolean[][] dp = new boolean[3][];
    int start = 0, end = 1;
    dp[0] = new boolean[n];
    for (int i = 0; i < n; i++)
      dp[0][i] = true;
    dp[1] = new boolean[n - 1];
    for (int i = 0; i < n - 1; i++) {
      if (c[i] == c[i + 1]) {
        dp[1][i] = true;
        start = i;
        end = i + 2;
      }
    }
    for (int diff = 2; diff < n; diff++) {
      dp[2] = new boolean[n - diff];
      for (int i = 0; i + diff < n; i++) {
        if (dp[diff % 2][i + 1] && c[i] == c[i + diff]) {
          dp[2][i] = true;
          start = i;
          end = i + diff + 1;
        }
      }
      dp[diff % 2] = dp[2];
    }
    return s.substring(start, end);
  }
}
