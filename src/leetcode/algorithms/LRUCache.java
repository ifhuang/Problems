package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

// https://oj.leetcode.com/problems/lru-cache/
public class LRUCache {
  private int c;
  private Map<Integer, DNode> map;
  private DNode head;
  private DNode tail;

  public LRUCache(int capacity) {
    c = capacity;
    map = new HashMap<>(capacity);
    head = new DNode(0, 0);
    tail = new DNode(0, 0);
    head.post = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DNode i = map.get(key);
      remove(i);
      addFirst(i);
      return i.v;
    } else
      return -1;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      DNode i = map.get(key);
      remove(i);
      i.v = value;
      addFirst(i);
    } else {
      if (map.size() == c)
        map.remove(removeLast().k);
      DNode i = new DNode(key, value);
      map.put(key, i);
      addFirst(i);
    }
  }

  private void remove(DNode n) {
    n.pre.post = n.post;
    n.post.pre = n.pre;
  }

  private void addFirst(DNode n) {
    n.pre = head;
    n.post = head.post;
    head.post = n;
    n.post.pre = n;
  }

  private DNode removeLast() {
    DNode old = tail.pre;
    tail.pre = old.pre;
    old.pre.post = tail;
    return old;
  }
}


class DNode {
  int k;
  int v;
  DNode pre;
  DNode post;

  DNode(int k, int v) {
    this.k = k;
    this.v = v;
  }
}
