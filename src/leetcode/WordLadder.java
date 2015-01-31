package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://oj.leetcode.com/problems/word-ladder/
public class WordLadder {
  public int ladderLength(String start, String end, Set<String> dict) {
    if (start.equals(end))
      return 1;
    int n = start.length();
    Map<String, Integer> map = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    map.put(start, 1);
    queue.offer(start);
    while (!queue.isEmpty()) {
      start = queue.poll();
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder(start);
        for (char c = 'a'; c <= 'z'; c++) {
          sb.setCharAt(i, c);
          String t = sb.toString();
          if (t.equals(end))
            return map.get(start) + 1;
          if (dict.contains(t) && !map.containsKey(t)) {
            map.put(t, map.get(start) + 1);
            queue.offer(t);
          }
        }
      }
    }
    return 0;
  }
}
