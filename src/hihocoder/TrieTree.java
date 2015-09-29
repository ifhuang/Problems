package hihocoder;

import java.io.PrintWriter;
import java.util.Scanner;

public class TrieTree {
  static Scanner in;
  static PrintWriter out;

  static void solve() {
    Trie trie = new Trie();
    int n = in.nextInt();
    while (n-- > 0) {
      trie.insert(in.next());
    }
    int m = in.nextInt();
    while (m-- > 0) {
      out.println(trie.query(in.next()));
    }
  }

  public static void main(String[] args) {
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    solve();
    out.close();
    in.close();
  }
}


class Trie {
  Node root;

  Trie() {
    root = new Node();
  }

  public void insert(String s) {
    Node p = root;
    for (char c : s.toCharArray()) {
      p.count++;
      int index = c - 'a';
      if (p.children[index] == null) {
        p.children[index] = new Node();
      }
      p = p.children[index];
    }
    p.count++;
  }

  public int query(String s) {
    Node p = root;
    for (char c : s.toCharArray()) {
      int index = c - 'a';
      if (p.children[index] == null) {
        return 0;
      }
      p = p.children[index];
    }
    return p.count;
  }
}


class Node {
  int count;
  Node[] children;

  Node() {
    count = 0;
    children = new Node[26];
  }
}
