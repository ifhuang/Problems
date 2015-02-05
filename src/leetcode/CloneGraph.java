package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.UndirectedGraphNode;

// https://oj.leetcode.com/problems/clone-graph/
public class CloneGraph {
  private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null)
      return node;
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    map.put(node, newNode);
    for (UndirectedGraphNode neighbor : node.neighbors)
      if (map.containsKey(neighbor))
        newNode.neighbors.add(map.get(neighbor));
      else
        newNode.neighbors.add(cloneGraph(neighbor));
    return newNode;
  }
}
