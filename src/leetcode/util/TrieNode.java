package leetcode.util;

public class TrieNode {
  public boolean flag;
  public TrieNode[] children;

  // Initialize your data structure here.
  public TrieNode() {
    flag = false;
    children = new TrieNode[26];
  }
}
