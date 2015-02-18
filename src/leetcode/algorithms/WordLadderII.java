package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://oj.leetcode.com/problems/word-ladder-ii/
public class WordLadderII {
  class Node {
    int count;
    List<String> pre;

    Node(int count) {
      this.count = count;
      this.pre = new ArrayList<>();
    }
  }

  private Map<String, Node> map;

  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    int n = start.length();
    dict.add(end);
    map = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    map.put(start, new Node(1));
    map.get(start).pre.add("");
    queue.offer(start);
    while (!queue.isEmpty() && !queue.peek().equals(end)) {
      start = queue.poll();
      Node node = map.get(start);
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder(start);
        for (char c = 'a'; c <= 'z'; c++) {
          sb.setCharAt(i, c);
          String t = sb.toString();
          if (!dict.contains(t))
            continue;
          if (!map.containsKey(t)) {
            map.put(t, new Node(node.count + 1));
            queue.offer(t);
          }
          Node no = map.get(t);
          if (no.count == node.count + 1)
            no.pre.add(start);
        }
      }
    }
    if (map.containsKey(end))
      return dfs(end);
    else
      return new ArrayList<>();
  }

  private List<List<String>> dfs(String end) {
    List<List<String>> ans = new ArrayList<>();
    if (end.isEmpty())
      ans.add(new ArrayList<>());
    else {
      Node node = map.get(end);
      for (String s : node.pre) {
        List<List<String>> pres = dfs(s);
        for (List<String> ss : pres) {
          List<String> copy = new ArrayList<>(ss);
          copy.add(end);
          ans.add(copy);
        }
      }
    }
    return ans;
  }
}
