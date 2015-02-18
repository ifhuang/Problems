package leetcode.algorithms;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://oj.leetcode.com/problems/word-break-ii/
public class WordBreakII {
  public List<String> wordBreak(String s, Set<String> dict) {
    Map<Integer, List<String>> dp = new HashMap<>();
    int n = s.length();
    List<String> list = new ArrayList<>();
    list.add("");
    dp.put(n, list);
    for (int i = n - 1; i >= 0; i--) {
      list = new ArrayList<>();
      for (int j = n; j > i; j--) {
        String word = s.substring(i, j);
        if (dict.contains(word))
          for (String item : dp.get(j))
            if (item.length() == 0)
              list.add(word);
            else
              list.add(word + " " + item);
      }
      dp.put(i, list);
    }
    return dp.get(0);
  }
}
