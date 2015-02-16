package leetcode;

// https://oj.leetcode.com/problems/decode-ways/
public class DecodeWays {
  public int numDecodings(String s) {
    int len = s.length();
    if (len == 0)
      return 0;
    int[] dp = new int[len + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i < len + 1; i++) {
      char now = s.charAt(i - 1);
      char pre = s.charAt(i - 2);
      if (now > '0')
        dp[i] += dp[i - 1];
      if (pre == '1' || (pre == '2' && now < '7'))
        dp[i] += dp[i - 2];
    }
    return dp[len];
  }
}
