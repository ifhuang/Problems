package leetcode.algorithms;

// https://oj.leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {
  public int minCut(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int[] ans = new int[n];
    for (int end = 0; end < n; end++) {
      ans[end] = end;
      for (int start = 0; start <= end; start++) {
        if (s.charAt(start) == s.charAt(end))
          dp[start][end] = (start == end || start + 1 == end ? true : dp[start + 1][end - 1]);
        if (dp[start][end])
          ans[end] = (start == 0 ? 0 : Math.min(ans[end], ans[start - 1] + 1));
      }
    }
    return ans[n - 1];
  }
}
