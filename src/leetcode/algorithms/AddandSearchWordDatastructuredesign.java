package leetcode.algorithms;

import leetcode.util.TrieNode;

public class AddandSearchWordDatastructuredesign {
  private TrieNode root;

  public AddandSearchWordDatastructuredesign() {
    root = new TrieNode();
  }

  // Adds a word into the data structure.
  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.flag = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return searchHelper(word, root);
  }

  private boolean searchHelper(String word, TrieNode node) {
    if (node == null)
      return false;
    if (word.length() == 0)
      return node.flag;
    char first = word.charAt(0);
    String post = word.substring(1);
    if (first == '.') {
      for (char c = 'a'; c <= 'z'; c++)
        if (searchHelper(post, node.children[c - 'a']))
          return true;
      return false;
    } else {
      return searchHelper(post, node.children[first - 'a']);
    }
  }
}
