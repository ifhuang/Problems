package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/lru-cache/
public class LRUCache {
  class DNode {
    int k;
    int v;
    DNode pre;
    DNode next;

    DNode(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }

  private int c;
  private Map<Integer, DNode> map;
  private DNode first;
  private DNode last;

  public LRUCache(int capacity) {
    c = capacity;
    map = new HashMap<>(capacity);
    first = new DNode(0, 0);
    last = new DNode(0, 0);
    first.next = last;
    last.pre = first;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DNode node = map.get(key);
      remove(node);
      addFirst(node);
      return node.v;
    } else {
      return -1;
    }
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      DNode node = map.get(key);
      remove(node);
      addFirst(node);
      node.v = value;
    } else {
      if (map.size() == c) {
        map.remove(removeLast().k);
      }
      DNode node = new DNode(key, value);
      map.put(key, node);
      addFirst(node);
    }
  }

  private void remove(DNode node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  private void addFirst(DNode node) {
    node.pre = first;
    node.next = first.next;
    first.next = node;
    node.next.pre = node;
  }

  private DNode removeLast() {
    DNode old = last.pre;
    last.pre = old.pre;
    old.pre.next = last;
    return old;
  }
}
