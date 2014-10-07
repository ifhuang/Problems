package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.util.UndirectedGraphNode;

public class CloneGraph
{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		if (node == null)
			return null;
		else if (node.neighbors.size() == 0)
		{
			UndirectedGraphNode root = new UndirectedGraphNode(node.label);
			return root;
		}
		else
		{
			Map<Integer, UndirectedGraphNode> map = new HashMap<>();
			Map<Integer, UndirectedGraphNode> newMap = new HashMap<>();
			copy(map, newMap, node);
			link(map, newMap);
			return newMap.get(node.label);
		}
	}

	private void copy(Map<Integer, UndirectedGraphNode> map,
			Map<Integer, UndirectedGraphNode> newMap, UndirectedGraphNode node)
	{
		if (!map.containsKey(node.label))
		{
			map.put(node.label, node);
			UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
			newMap.put(newNode.label, newNode);
		}
		for (UndirectedGraphNode n : node.neighbors)
			if (!map.containsKey(n.label))
				copy(map, newMap, n);
	}

	private void link(Map<Integer, UndirectedGraphNode> map,
			Map<Integer, UndirectedGraphNode> newMap)
	{
		for (int key : map.keySet())
		{
			UndirectedGraphNode node = map.get(key);
			UndirectedGraphNode newNode = newMap.get(key);
			for (UndirectedGraphNode n : node.neighbors)
				newNode.neighbors.add(newMap.get(n.label));
		}
	}
}