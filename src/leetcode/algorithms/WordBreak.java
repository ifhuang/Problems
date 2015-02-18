package leetcode.algorithms;

import java.util.Set;

// https://oj.leetcode.com/problems/word-break/
public class WordBreak {
  public boolean wordBreak(String s, Set<String> dict) {
    int n = s.length() + 1;
    boolean[] dp = new boolean[n];
    dp[0] = true;
    for (int i = 1; i < n; i++)
      for (int j = 0; j < i; j++)
        if (dp[j] && dict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
    return dp[n - 1];
  }
}
