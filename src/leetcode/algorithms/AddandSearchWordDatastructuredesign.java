package leetcode.algorithms;

import leetcode.util.TrieNode;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/
public class AddandSearchWordDatastructuredesign {
  private TrieNode root;

  public AddandSearchWordDatastructuredesign() {
    root = new TrieNode();
  }

  // Adds a word into the data structure.
  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node = node.children[index];
    }
    node.flag = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return dfs(word, root);
  }

  private boolean dfs(String word, TrieNode node) {
    if (node == null) {
      return false;
    } else if (word.length() == 0) {
      return node.flag;
    }
    char first = word.charAt(0);
    String post = word.substring(1);
    if (first == '.') {
      for (char c = 'a'; c <= 'z'; c++) {
        if (dfs(post, node.children[c - 'a'])) {
          return true;
        }
      }
      return false;
    } else {
      return dfs(post, node.children[first - 'a']);
    }
  }
}
