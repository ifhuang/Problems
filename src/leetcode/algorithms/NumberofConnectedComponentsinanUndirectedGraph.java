package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of
// nodes), write a function to find the number of connected components in an undirected graph.
// Note:
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,
// 1] is the same as [1, 0] and thus will not appear together in edges.
public class NumberofConnectedComponentsinanUndirectedGraph {
  class Graph {
    private final int V;
    private int E;
    private List<List<Integer>> adj;

    public Graph(int V) {
      this.V = V;
      E = 0;
      adj = new ArrayList<>();
      for (int v = 0; v < V; v++) {
        adj.add(new ArrayList<>());
      }
    }

    public int V() {
      return V;
    }

    public int E() {
      return E;
    }

    public void addEdge(int v, int w) {
      E++;
      adj.get(v).add(w);
      adj.get(w).add(v);
    }

    public Iterable<Integer> adj(int v) {
      return adj.get(v);
    }

    public int degree(int v) {
      return adj.get(v).size();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("V: ").append(V).append("\n");
      sb.append("E: ").append(E).append("\n");
      for (int v = 0; v < V; v++) {
        sb.append(v).append(":");
        for (int w : adj(v)) {
          sb.append(" ").append(w);
        }
        sb.append("\n");
      }
      return sb.toString();
    }
  }

  class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    private Map<Integer, Integer> size;

    public CC(Graph graph) {
      marked = new boolean[graph.V()];
      id = new int[graph.V()];
      count = 0;
      size = new HashMap<>();
      for (int i = 0; i < graph.V(); i++) {
        if (!marked[i]) {
          dfs(graph, i);
          count++;
        }
      }
    }

    private void dfs(Graph graph, int s) {
      marked[s] = true;
      id[s] = count;
      if (!size.containsKey(count)) {
        size.put(count, 0);
      }
      size.put(count, size.get(count) + 1);
      for (int t : graph.adj(s)) {
        if (!marked[t]) {
          dfs(graph, t);
        }
      }
    }

    public boolean connected(int v, int w) {
      return id[v] == id[w];
    }

    public int count() {
      return count;
    }

    public int id(int v) {
      return id[v];
    }

    public int size(int v) {
      return size.get(id[v]);
    }
  }

  public int countComponents(int n, int[][] edges) {
    Graph graph = new Graph(n);
    for (int i = 0; i < edges.length; i++) {
      graph.addEdge(edges[i][0], edges[i][1]);
    }
    CC cc = new CC(graph);
    return cc.count();
  }
}
