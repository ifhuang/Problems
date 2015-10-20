package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.UndirectedGraphNode;

// https://oj.leetcode.com/problems/clone-graph/
public class CloneGraph {
  private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return node;
    }
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    map.put(node.label, newNode);
    for (UndirectedGraphNode neighbor : node.neighbors) {
      if (map.containsKey(neighbor.label)) {
        newNode.neighbors.add(map.get(neighbor.label));
      } else {
        newNode.neighbors.add(cloneGraph(neighbor));
      }
    }
    return newNode;
  }
}
