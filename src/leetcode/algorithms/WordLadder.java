package leetcode.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://oj.leetcode.com/problems/word-ladder/
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    Map<String, Integer> map = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    map.put(beginWord, 1);
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      String word = queue.poll();
      for (int i = 0; i < word.length(); i++) {
        StringBuilder sb = new StringBuilder(word);
        for (char c = 'a'; c <= 'z'; c++) {
          sb.setCharAt(i, c);
          String newWord = sb.toString();
          if (wordList.contains(newWord) && !map.containsKey(newWord)) {
            map.put(newWord, map.get(word) + 1);
            queue.offer(newWord);
          }
        }
      }
    }
    return map.containsKey(endWord) ? map.get(endWord) : 0;
  }
}
