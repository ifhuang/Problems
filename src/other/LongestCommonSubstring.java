package other;

public class LongestCommonSubstring {
  public int length(String a, String b) {
    int m = a.length();
    int n = b.length();
    if (m == 0 || n == 0) {
      return 0;
    }
    int[][] dp = new int[m][n];
    dp[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
    for (int i = 1; i < m; i++) {
      dp[i][0] = a.charAt(i) == b.charAt(0) ? 1 : dp[i - 1][0];
    }
    for (int j = 1; j < n; j++) {
      dp[0][j] = a.charAt(0) == b.charAt(j) ? 1 : dp[0][j - 1];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = a.charAt(i) == b.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
      }
    }
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    System.out.println(lcs.length("aaxb", "bab"));
  }
}
