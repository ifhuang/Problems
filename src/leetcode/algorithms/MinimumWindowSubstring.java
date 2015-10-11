package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    int count = t.length();
    int start = 0;
    int end = 0;
    int len = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (true) {
      if (count == 0) {
        if (i == s.length()) {
          break;
        }
        char c = s.charAt(i);
        if (map.containsKey(c)) {
          int v = map.get(c);
          if (v == 0) {
            count++;
            int newLen = j - i;
            if (newLen < len) {
              start = i;
              end = j;
              len = newLen;
            }
          }
          map.put(c, v + 1);
        }
        i++;
      } else {
        if (j == s.length()) {
          break;
        }
        char c = s.charAt(j);
        if (map.containsKey(c)) {
          int v = map.get(c);
          if (v > 0) {
            count--;
          }
          map.put(c, v - 1);
        }
        j++;
      }
    }
    return s.substring(start, end);
  }
}
