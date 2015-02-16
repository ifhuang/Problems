package leetcode;

// https://oj.leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    int len = s.length();
    if (len == 0)
      return 0;
    int max = 0;
    int[] dp = new int[len];
    dp[len - 1] = 0;
    for (int i = len - 2; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        int j = (i + 1) + dp[i + 1];
        if (j < len && s.charAt(j) == ')') {
          dp[i] = dp[i + 1] + 2;
          if (j + 1 < len)
            dp[i] += dp[j + 1];
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
