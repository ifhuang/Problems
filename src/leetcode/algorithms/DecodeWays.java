package leetcode.algorithms;

// https://oj.leetcode.com/problems/decode-ways/
public class DecodeWays {
  // time O(n), space O(n)
  public int numDecodings(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      int j = i - 1;
      char c = s.charAt(j);
      if (c >= '1' && c <= '9') {
        dp[i] = dp[i - 1];
      }
      if (j > 0) {
        char b = s.charAt(j - 1);
        if ((b == '1' && c >= '0' && c <= '9') || (b == '2' && c >= '0' && c <= '6')) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[n];
  }
}
