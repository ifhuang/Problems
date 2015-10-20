package leetcode.algorithms;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://oj.leetcode.com/problems/word-break-ii/
public class WordBreakII {
  public List<String> wordBreak(String s, Set<String> dict) {
    if (!check(s, dict)) {
      return new ArrayList<>();
    }
    Map<Integer, List<String>> dp = new HashMap<>();
    int n = s.length();
    List<String> list = new ArrayList<>();
    list.add("");
    dp.put(0, list);
    for (int i = 1; i <= n; i++) {
      list = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        String word = s.substring(j, i);
        if (dict.contains(word)) {
          for (String item : dp.get(j)) {
            list.add(item.isEmpty() ? word : item + " " + word);
          }
        }
      }
      dp.put(i, list);
    }
    return dp.get(n);
  }

  private boolean check(String s, Set<String> wordDict) {
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
