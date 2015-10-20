package leetcode.algorithms;

import java.util.Set;

// https://oj.leetcode.com/problems/word-break/
public class WordBreak {
  // time O(n^2), space O(n)
  public boolean wordBreak(String s, Set<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[n];
  }
}
