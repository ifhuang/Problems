package leetcode.algorithms;

class TrieNode {
  boolean flag;
  TrieNode[] children;

  // Initialize your data structure here.
  public TrieNode() {
    flag = false;
    children = new TrieNode[26];
  }
}


public class ImplementTrie {
  private TrieNode root;

  public ImplementTrie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode p = root;
    for (int i = 0; i < word.length(); i++) {
      int j = word.charAt(i) - 'a';
      if (p.children[j] == null)
        p.children[j] = new TrieNode();
      p = p.children[j];
    }
    p.flag = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode p = helper(word);
    return p != null && p.flag;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    return helper(prefix) != null;
  }

  private TrieNode helper(String s) {
    TrieNode p = root;
    for (int i = 0; i < s.length(); i++) {
      int j = s.charAt(i) - 'a';
      if (p.children[j] == null)
        return null;
      p = p.children[j];
    }
    return p;
  }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
