package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubstringwithConcatenationofAllWords {
  // time O(n*m), space O(m)
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> countMap = count(words);
    int n = s.length();
    int m = words.length;
    int t = words[0].length();
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i + m * t <= n; i++) {
      Map<String, Integer> copyMap = new HashMap<>(countMap);
      for (int j = 0; j < m; j++) {
        String word = s.substring(i + j * t, i + j * t + t);
        if (copyMap.containsKey(word)) {
          int c = copyMap.get(word);
          if (c > 1) {
            copyMap.put(word, c - 1);
          } else {
            copyMap.remove(word);
          }
        } else {
          break;
        }
      }
      if (copyMap.isEmpty()) {
        ans.add(i);
      }
    }
    return ans;
  }

  private Map<String, Integer> count(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }
    return map;
  }
}
