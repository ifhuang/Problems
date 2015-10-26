package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/alien-dictionary/
// There is a new alien language which uses the latin alphabet. However, the order among letters are
// unknown to you. You receive a list of words from the dictionary, where words are sorted
// lexicographically by the rules of this new language. Derive the order of letters in this
// language.
// For example,
// Given the following words in dictionary,
// [
// "wrt",
// "wrf",
// "er",
// "ett",
// "rftt"
// ]
// The correct order is: "wertf".
// Note:
// You may assume all letters are in lowercase.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.
public class AlienDictionary {
  public String alienOrder(String[] words) {
    Map<Character, List<Character>> graph = new HashMap<>();
    String ans = null;
    Set<Character> charSet = new HashSet<>(); // Maintain a set of chars that are not in the graph.
    buildGraph(words, graph, charSet);
    ans = toposortDFS(graph, charSet);
    return ans;
  }

  private Set<Character> getCharSet(String[] words, Set<Character> charSet) {
    for (String word : words) {
      for (char c : word.toCharArray()) {
        charSet.add(c);
      }
    }
    return charSet;
  }

  private String toposortDFS(Map<Character, List<Character>> graph, Set<Character> charSet) {
    StringBuffer ans = new StringBuffer();
    boolean[] visited = new boolean[26]; // permanent marker.
    boolean[] tempMark = new boolean[26]; // temporary marker
    for (Character v : graph.keySet()) {
      if (!visited[v - 'a']) {
        if (!visitDFS(ans, graph, visited, v, tempMark)) {
          return "";
        }
      }
    }
    for (Character c : charSet) { // insert orphan chars.
      ans.insert(0, c);
    }
    return ans.reverse().toString();
  }

  private boolean visitDFS(StringBuffer ans, Map<Character, List<Character>> graph,
      boolean[] visited, Character node, boolean[] marked) {
    if (marked[node - 'a']) { // if temporally marked already, it is not DAG. return failure(false);
      return false;
    }
    if (!visited[node - 'a']) {
      marked[node - 'a'] = true; // mark the current node temporally.
      List<Character> adjList = graph.get(node);
      if (adjList != null) {
        for (Character m : graph.get(node)) {
          if (!visitDFS(ans, graph, visited, m, marked))
            return false;
        }
      }
      // there is no adjacent node, it is a leaf, output the node(char).
      visited[node - 'a'] = true; // mark the node permanently.
      marked[node - 'a'] = false; // remove the temp mark.
      ans.append(node);
    }
    return true;
  }

  private void buildGraph(String[] words, Map<Character, List<Character>> graph,
      Set<Character> charSet) {
    getCharSet(words, charSet); // Find all chars in the words.
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = i + 1; j < words.length; j++) {
        for (int k = 0; k < Math.min(words[i].length(), words[j].length()); k++) {
          if (words[i].charAt(k) != words[j].charAt(k)) {
            charSet.remove(words[i].charAt(k)); // Remove the chars that are in the graph from
                                                // charSet.
            charSet.remove(words[j].charAt(k));
            if (graph.containsKey(words[i].charAt(k))) {
              List<Character> adjList = graph.get(words[i].charAt(k));
              if (!adjList.contains(words[j].charAt(k)))
                graph.get(words[i].charAt(k)).add(words[j].charAt(k));
            } else {
              List<Character> adjList = new ArrayList<Character>();
              adjList.add(words[j].charAt(k));
              graph.put(words[i].charAt(k), adjList);
            }
            break;
          }
        }
      }
    }
  }
}
