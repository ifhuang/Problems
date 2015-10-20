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

  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    Map<String, Node> map = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    map.put(start, new Node(1));
    map.get(start).pre.add("");
    queue.offer(start);
    while (!queue.isEmpty()) {
      String word = queue.poll();
      Node node = map.get(word);
      for (int i = 0; i < word.length(); i++) {
        StringBuilder sb = new StringBuilder(word);
        for (char c = 'a'; c <= 'z'; c++) {
          sb.setCharAt(i, c);
          String newWord = sb.toString();
          if (dict.contains(newWord)) {
            if (!map.containsKey(newWord)) {
              map.put(newWord, new Node(node.count + 1));
              queue.offer(newWord);
            }
            Node newNode = map.get(newWord);
            if (newNode.count == node.count + 1) {
              newNode.pre.add(word);
            }
          }
        }
      }
    }
    return map.containsKey(end) ? dfs(end, map) : new ArrayList<>();
  }

  private List<List<String>> dfs(String end, Map<String, Node> map) {
    List<List<String>> ans = new ArrayList<>();
    if (end.isEmpty()) {
      ans.add(new ArrayList<>());
    } else {
      Node node = map.get(end);
      for (String s : node.pre) {
        List<List<String>> pres = dfs(s, map);
        for (List<String> pre : pres) {
          List<String> copy = new ArrayList<>(pre);
          copy.add(end);
          ans.add(copy);
        }
      }
    }
    return ans;
  }
}
