package lintcode;

// http://www.lintcode.com/en/problem/longest-common-substring/
public class LongestCommonSubstring {
  /**
   * @param A, B: Two string.
   * @return: the length of the longest common substring.
   */
  public int longestCommonSubstring(String A, String B) {
    // write your code here
    int m = A.length(), n = B.length();
    int[][] dp = new int[m + 1][n + 1];
    int ans = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : 0;
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }
}
